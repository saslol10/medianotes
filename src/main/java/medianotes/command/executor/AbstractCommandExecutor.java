package medianotes.command.executor;

import medianotes.model.Folder;
import medianotes.model.Note;
import medianotes.repository.FolderRepository;
import medianotes.repository.NoteRepository;
import medianotes.repository.impl.FolderRepositoryImpl;
import medianotes.repository.impl.NoteRepositoryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCommandExecutor implements CommandExecutor {

    //public abstract int execute(String text);

    //protected - поле или метод доступны наследникам
    protected final NoteRepository noteRepository = NoteRepositoryImpl.getSingleton();
    //создание экземпляра интерфейса
    protected final FolderRepository folderRepository = FolderRepositoryImpl.getSingleton();

    protected Optional<Note> findNote(String noteName) {
        for (Note note : noteRepository.findAll()) {
            if (note.getName().equals(noteName)) {
                return Optional.of(note);
            }
        }

        return Optional.empty();
    }

    protected Optional<Folder> findFolder(String folderName) {
        for (Folder folder : folderRepository.findAll()) {
            if (folder.name().equals(folderName)) {
                return Optional.of(folder);
            }
        }
        return Optional.empty();
    }

    protected List<String> findFolderPath(String name){
        var note = findNote(name);

        if(note.isEmpty()){
            return null;
        }
        return findFolderPath(note.get());
    }

    private List<String> findFolderPath(Note note){
        List<String> path = new LinkedList<>();

        findFolderPath((note.getParentFolder()),path);

        return path;
    }

    //Рекурсия
    private void findFolderPath(Folder folder, List<String> path) {
        path.add(folder.name());

        if (folder.parentFolder() != null) {
            findFolderPath(folder.parentFolder(), path);
        }
    }


}
