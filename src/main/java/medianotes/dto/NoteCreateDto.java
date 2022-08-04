package medianotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NoteCreateDto {

    private final String title;

    private final String text;

    private final String authorEmail;

    public NoteCreateDto(@JsonProperty("title") String title,
                         @JsonProperty("text") String text,
                         @JsonProperty("authorEmail") String authorEmail) {
        this.title = title;
        this.text = text;
        this.authorEmail = authorEmail;
    }
}
