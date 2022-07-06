package medianotes.repository;

import medianotes.model.Note;

import java.util.Set;

/**
 * interface
 */
public interface NoteRepository {

    void save(Note note);
    // метод для сохранения заметок
    //public не пишем, так как очевидно что должно быть доступно в классе
    //не void, так как обычно метод save возвращает объект этого же класса (изменено)

    //Показ всех заметок
    Set<Note> findAll();

    //Удаление заметки по имени
    void remove(Note note);


}
