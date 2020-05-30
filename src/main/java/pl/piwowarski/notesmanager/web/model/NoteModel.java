package pl.piwowarski.notesmanager.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteModel {
                    
    private Long id;

    private String title;

    private String content;



}
