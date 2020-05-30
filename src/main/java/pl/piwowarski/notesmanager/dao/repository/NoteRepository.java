package pl.piwowarski.notesmanager.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.notesmanager.dao.entity.NoteEntity;


@Repository
public interface NoteRepository extends JpaRepository<NoteEntity,Long>{



}
