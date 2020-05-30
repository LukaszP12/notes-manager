package pl.piwowarski.notesmanager.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.web.model.NoteModel;

@Component
public class NoteMapper {

    public NoteModel fromEntity(NoteEntity noteEntity){
//        NoteModel noteModel = new NoteModel();
//        noteModel.setId(noteEntity.getId());
//        noteModel.setTitle(noteEntity.getTitle());
//        noteModel.setContent(noteEntity.getContent());
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(noteEntity, NoteModel.class);
    }

    public NoteEntity fromModel(NoteModel noteModel){
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(noteEntity.getId());
        noteEntity.setTitle(noteEntity.getTitle());
        noteEntity.setContent(noteEntity.getContent());
        return noteEntity;
    }


}
