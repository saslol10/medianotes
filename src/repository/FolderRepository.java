package src.repository;

import src.model.Folder;
import src.model.Note;

import java.util.Set;

public interface FolderRepository {
    Set<Folder> findAll();

    void save(Folder newFolder);
}
