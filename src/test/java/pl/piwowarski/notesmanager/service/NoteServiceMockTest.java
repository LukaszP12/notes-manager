package pl.piwowarski.notesmanager.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.dao.repository.NoteRepository;
import pl.piwowarski.notesmanager.service.mapper.NoteMapper;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class NoteServiceMockTest {

    @Mock
    private NoteRepository noteRepository;
    @Mock
    private NoteMapper noteMapper;
    @InjectMocks
    private NoteService noteService;

    @Test
    void read(){
        //GIVEN
        // NoteService noteService = new NoteService(noteRepository,noteMapper);
        //WHEN
        when(noteRepository.findById(2L)).thenReturn(Optional.of(new NoteEntity()));
        when(noteService.read(2L)).thenReturn(new NoteModel());

        NoteModel readNoteModel = noteService.read(2L);
        //THEN
        Assertions.assertNotNull(readNoteModel,"readNoteModel is null");
    }

    @Test
    void list(){
        //GIVEN

        //WHEN
        when(noteService.list()).thenReturn(Arrays.asList(new NoteModel()));
        List<NoteModel> noteModels = noteService.list();

        //THEN
        Assertions.assertEquals(1,noteModels.size(),"Size is not 0");
    }

    @Test
    void delete(){
        //GIVEN

        //WHEN
        doNothing().when(noteRepository).deleteById(1L);
        noteService.delete(1L);
        //THEN
        verify(noteRepository,times(1)).deleteById(1L);
    }

    //toDo Mockito dla metody Update(z Service)

}
