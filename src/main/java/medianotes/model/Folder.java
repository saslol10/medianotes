package medianotes.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Folder {

    @EqualsAndHashCode.Include
    private String name;

    private Folder parentFolder;

    public Folder(String name, Folder parentFolder) {
        this.name = name;
        this.parentFolder = parentFolder;
    }
}
