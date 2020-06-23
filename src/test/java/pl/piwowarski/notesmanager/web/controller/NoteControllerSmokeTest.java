package pl.piwowarski.notesmanager.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoteControllerSmokeTest {

    @Autowired
    private NoteController noteController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(noteController);
    }

}