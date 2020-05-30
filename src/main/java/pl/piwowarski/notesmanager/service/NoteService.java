package pl.piwowarski.notesmanager.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.dao.repository.NoteRepository;
import pl.piwowarski.notesmanager.service.mapper.NoteMapper;
import pl.piwowarski.notesmanager.web.controller.NoteController;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class NoteService {

    private static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());

    private List<NoteModel> notes = new ArrayList<>();

    private NoteRepository noteRepository;

    private NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public List<NoteModel> list() {
        LOGGER.info("Listing All Notes");
        List<NoteEntity> entities = noteRepository.findAll();
        return notes;
    }

    public NoteModel create(NoteModel noteModel) {
         notes.add(noteModel);
         return noteModel;
    }

    public NoteModel read(@PathVariable(name = "id") Long id) {
        LOGGER.info("Reading note with id: " + id);

//        Optional<NoteModel> optionalNoteModel = notes.stream()
//                .filter(note -> note.getId().equals(id))
//                .findFirst();

//        return optionalNoteModel.orElse(new NoteModel()); // FIXME użyć orElseThrow

        Optional<NoteEntity> optionalNoteEntity = noteRepository.findById(id);
        NoteEntity noteEntity = optionalNoteEntity.orElse(new NoteEntity());
        return noteMapper.fromEntity(noteEntity);
    }

    public NoteModel update(@PathVariable(name = "id") Long id, @RequestBody NoteModel noteModel) {
        for (NoteModel note : notes){
            if (note.getId().equals(id)){
                note.setTitle(noteModel.getTitle());
                note.setContent(noteModel.getContent());
                return note;
            }
        }
        return noteModel;
    }

    public void delete(@PathVariable(name = "id") Long id) {
        for (NoteModel note : notes){
            if (note.getId().equals(id)){
                notes.remove(note);
            }
        }
    }


}
