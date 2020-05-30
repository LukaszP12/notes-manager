package pl.piwowarski.notesmanager.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.notesmanager.service.NoteService;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    private static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<NoteModel> list() {
        LOGGER.info("Listing All Notes");
        return noteService.list();
    }

    @PostMapping
    public NoteModel create(@RequestBody NoteModel noteModel) {
        return noteService.create(noteModel);
    }

    @GetMapping("/{id}")
    public NoteModel read(@PathVariable(name = "id") Long id) {
        LOGGER.info("Reading note with id: " + id);
        return noteService.read(id);
    }

    @PutMapping("/{id}")
    public NoteModel update(@PathVariable(name = "id") Long id, @RequestBody NoteModel noteModel) {
        return noteService.update(id, noteModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        noteService.delete(id);
    }


}
