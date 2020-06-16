package pl.piwowarski.notesmanager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.piwowarski.notesmanager.dao.repository.NoteRepository;
import pl.piwowarski.notesmanager.service.mapper.NoteMapper;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.List;

@SpringBootTest
class NoteServiceIntegrationTest {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteMapper noteMapper;

    @Test
    void create() {
        //GIVEN
        NoteService noteService = new NoteService(noteRepository,noteMapper);
        NoteModel noteModel = new NoteModel();

        //WHEN
        NoteModel createdNoteModel = noteService.create(noteModel);

        //THEN
        Assertions.assertNotNull(createdNoteModel,"createdNoteModel is null");

    }

    @Test
    void create1(){
        //GIVEN
        NoteService noteService = new NoteService(noteRepository,noteMapper);
        NoteModel noteModel = new NoteModel();

        //WHEN
        NoteModel createdNoteModel = noteService.create(noteModel);

        //THEN
        Assertions.assertNotNull(createdNoteModel.getId(),"createdNoteModel Id is null");
    }

    @Test
    void read(){
        //GIVEN
        NoteService noteService = new NoteService(noteRepository,noteMapper);
        NoteModel noteModel = new NoteModel();

        //WHEN
        NoteModel createdNoteModel = noteService.create(noteModel);

        NoteModel readNoteModel = noteService.read(createdNoteModel.getId());

        //THEN
        Assertions.assertNotNull(readNoteModel,"readNoteModel is null");

    }

    @Test
    void delete(){
        //delete
        NoteService noteService = new NoteService(noteRepository,noteMapper);
        NoteModel noteModel = new NoteModel();

        //when
        NoteModel createdNoteModel = noteService.create(noteModel);
        noteService.delete(createdNoteModel.getId());
        List<NoteModel> noteModels = noteService.list();

        //then
        Assertions.assertEquals(0, noteModels.size(), "noteModels does not equal 0");
    }

    //ToDo update oraz list

}