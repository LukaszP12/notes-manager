package pl.piwowarski.notesmanager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.piwowarski.notesmanager.service.NoteService;
import pl.piwowarski.notesmanager.web.model.NoteModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/web/notes")
public class NoteWebController {

    private static final Logger LOGGER = Logger.getLogger(NoteWebController.class.getName());

    private NoteService noteService;

    @Autowired
    public NoteWebController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        List<NoteModel> notes = noteService.list();
        LOGGER.info("## Notes: " + notes);
        modelMap.addAttribute("notes",notes);
        return "notes";
    }

    @GetMapping("/create")
    public String createView(){
        LOGGER.info("create view ");
        return "create-note";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content) {
        LOGGER.info("create");
        LOGGER.info("request param title:  " + title);
        LOGGER.info("request param content:  " + content);
        noteService.create(new NoteModel(1L,title,content));
        return "redirect:/web/notes";
    }

    @GetMapping("/details")
    public String read() {
        return "notes";
    }

    @GetMapping("/edit")
    public String updateView() {
        return "update-note";
    }

    @PostMapping("/edit")
    public String update(){
        return "notes";
    }

    @GetMapping("/delete")
    public String delete() {
        return "notes";
    }

    // toDo zaimplementować metodę updateView i update
    // toDo doczytać @ModelAttribute, @SessionAttribute

}
