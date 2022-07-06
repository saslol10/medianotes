package medianotes.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

/**
 * javadoc
 */

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Note {

    private  Folder parentFolder;

    @EqualsAndHashCode.Include
    private final String name; // название

    private String text; // содержание

    private final String author; // автор

    private final Instant creationDate; // дата создания
    private Instant updateDate; // дата изменений

     public Note(String name, String text,  Folder parentFolder){
         this.parentFolder = parentFolder;

         this.name = name;
         this.text = text;

         author = null;

         creationDate = Instant.now();
     }

     public void setText(String text) {
         this.text = text;
         this.updateDate = Instant.now();
     }
}
