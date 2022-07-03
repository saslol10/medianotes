package src.command.executor;

import src.Note;
import src.repository.NoteRepository;
import src.repository.impl.NoteRepositoryImpl;

import java.util.Optional;

public abstract class AbstractCommandExecutor implements CommandExecutor {

    //public abstract int execute(String text);

    //protected - поле или метод доступны наследникам
    protected final NoteRepository noteRepository = NoteRepositoryImpl.getSingleton();
//создание экземпляра интерфейса

    protected Optional<Note> findNote(String noteName) {
        for (Note note : noteRepository.findAll()) {
            if (note.getName().equals(noteName)) {
                return Optional.of(note);
            }
        }

        return Optional.empty();
    }

}
