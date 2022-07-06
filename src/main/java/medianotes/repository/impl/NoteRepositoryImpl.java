package medianotes.repository.impl;

import medianotes.model.Note;
import medianotes.repository.NoteRepository;

import java.util.HashSet;

import java.util.Set;


public class NoteRepositoryImpl implements NoteRepository {

    private static  final Set<Note> NOTES = new HashSet<>();

    private static final NoteRepositoryImpl SINGLETON = new NoteRepositoryImpl();

    private NoteRepositoryImpl() {}

    public static NoteRepository getSingleton() {
        return SINGLETON;
    }

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
