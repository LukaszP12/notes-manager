package pl.piwowarski.notesmanager.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.Arrays;
import java.util.List;

class NoteMapperTest {

    public static final String NOTE_TITLE = "Programowanie w Springu";

    @Test
    void givenNoteMapper_whenFromEntity_thenNoteModelNotNull() {
        //GIVEN
        NoteMapper noteMapper = new NoteMapper();
        NoteEntity noteEntity = new NoteEntity();
        //WHEN
        NoteModel noteModel = noteMapper.fromEntity(noteEntity);
        //THEN
        Assertions.assertNotNull(noteModel, "Note model is null");
    }

    @Test
    void givenNoteMapper_whenFromEntity_thenNoteModelTitleIsEqual() {
        //GIVEN
        NoteMapper noteMapper = new NoteMapper();
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setTitle(NOTE_TITLE);
        //WHEN
        NoteModel noteModel = noteMapper.fromEntity(noteEntity);
        //THEN
        Assertions.assertEquals(NOTE_TITLE, noteModel.getTitle(), "Titles are not equal");
    }


    @Test
    void fromEntities() {
        //GIVEN
        NoteMapper noteMapper = new NoteMapper();
        List<NoteEntity> entities = Arrays.asList(
                new NoteEntity(1L,"1st Entity","1st Content"),
                new NoteEntity(2L,"2nd Entity","2nd Content")
        );
        //WHEN
        List<NoteModel> noteModels = noteMapper.fromEntities(entities);
        //THEN
        Assertions.assertEquals(entities.size(),noteModels.size(), "Sizes are not equal");
    }

    @Test
    void given_When_Then() {
        //GIVEN
        NoteMapper noteMapper = new NoteMapper();
        NoteEntity noteEntity = new NoteEntity(3L,"Aplikacja Notes","Aplikacje do zarządzania");
        //WHEN
        NoteModel noteModel = noteMapper.fromEntity(noteEntity);
        //THEN
        Assertions.assertAll(
                () -> Assertions.assertNotNull(noteModel.getTitle()),
                () -> Assertions.assertNotNull(noteModel.getContent()),
                () -> Assertions.assertNotNull(noteModel.getId())
        );
    }


}