package src.repository.impl;

import src.Note;
import src.repository.NoteRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * implements interface
 */

public class NoteRepositoryImpl implements NoteRepository {

    //Определение списка
    //private; static - один на всю программу
    //final - неизменяемый
    //Получается константа
    //private static  final List<Note> NOTES = new LinkedList<>();

    //У заметок должны быть уникальные названия ->Set
    private static  final Set<Note> NOTES = new HashSet<>();

    //@Override переопределение / реализация метода
    @Override
    public void save(Note note) {
        NOTES.add(note);
    }

    @Override
    public Set<Note> findAll() {
        return NOTES;
    }

    @Override
    public void remove(Note note) {
        NOTES.remove(note);
    }
}
