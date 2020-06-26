package pl.piwowarski.notesmanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.dao.repository.NoteRepository;
import pl.piwowarski.notesmanager.service.mapper.NoteMapper;
import pl.piwowarski.notesmanager.web.controller.NoteController;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class NoteService {

    private static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    @Autowired
    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public List<NoteModel> list() {
        LOGGER.info("Listing All Notes");
        List<NoteEntity> entities = noteRepository.findAll();
//        return Arrays.asList(
//                new NoteModel(1L,"Note about Java","Java is object oriented programming"),
//                new NoteModel(2L,"Note about Thymeleaf","Thymeleaf is template framework")
//        );

        return noteMapper.fromEntities(entities);
    }

    public NoteModel create(NoteModel noteModel) {
        NoteEntity noteEntity = noteMapper.fromModel(noteModel);
        NoteEntity savedNoteEntity = noteRepository.save(noteEntity);
        return noteMapper.fromEntity(savedNoteEntity);
    }

    public NoteModel read(Long id) {
        LOGGER.info("Reading note with id: " + id);

//      return optionalNoteModel.orElse(new NoteModel()); // FIXME użyć orElseThrow

        Optional<NoteEntity> optionalNoteEntity = noteRepository.findById(id);
        NoteEntity noteEntity = optionalNoteEntity.orElse(new NoteEntity());
        return noteMapper.fromEntity(noteEntity);
    }

    public NoteModel update(Long id, NoteModel noteModel) {
        LOGGER.info("Updating note with Id: " + id + " new note " + noteModel);

        NoteEntity noteEntity = noteMapper.fromModel(noteModel);
        NoteEntity savedNoteEntity = noteRepository.save(noteEntity);

        return noteMapper.fromEntity(savedNoteEntity);
    }

    public void delete(Long id) {
        LOGGER.info("Deleting note with Id: " + id);
        noteRepository.deleteById(id);
    }


}
