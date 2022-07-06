package medianotes.repository;

import medianotes.model.Folder;
import medianotes.model.Note;

import java.util.Set;

public interface FolderRepository {
    Set<Folder> findAll();

    void save(Folder newFolder);
}
