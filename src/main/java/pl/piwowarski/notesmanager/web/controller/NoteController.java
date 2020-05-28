package pl.piwowarski.notesmanager.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    private static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());

    @GetMapping
    public List<NoteModel> list() {
        LOGGER.info("Listing All Notes");
        return null;
    }

    @PostMapping
    public NoteModel create(NoteModel noteModel) {
        return null;
    }

    @GetMapping("/{id}")
    public NoteModel read(@PathVariable(name = "id") Long id) {
        LOGGER.info("Reading note with id: " + id);
        return null;
    }

    @PutMapping("/{id}")
    public NoteModel update(@PathVariable(name = "id") Long id, @RequestBody NoteModel noteModel) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

    }


}
