package pl.piwowarski.notesmanager.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.List;
import java.util.stream.Collectors;

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
        noteEntity.setId(noteModel.getId());
        noteEntity.setTitle(noteModel.getTitle());
        noteEntity.setContent(noteModel.getContent());
        return noteEntity;
    }

    public List<NoteModel> fromEntities(List<NoteEntity> entities){
        return entities.stream()
//                .filter(noteEntity -> noteEntity.getId() %2 == 0)
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    // toDo dopisać metodę testowa dla fromModel, sprawdzającą czy pola zostały wypełnione

    // toDo dopisać metodę fromModels analogicznie do fromEntities


}
