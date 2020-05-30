package pl.piwowarski.notesmanager.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.web.model.NoteModel;

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


}