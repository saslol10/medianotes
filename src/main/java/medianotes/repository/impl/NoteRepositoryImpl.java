package medianotes.repository.impl;

import medianotes.model.Note;
import medianotes.repository.NoteRepository;

import java.io.*;
import java.util.HashSet;

import java.util.Objects;
import java.util.Set;


public class NoteRepositoryImpl implements NoteRepository {

    private static final  String DATA_FILE_NAME = "data-note.dat";

    private static  final Set<Note> NOTES = new HashSet<>();

    static {
        loadDataToFile();
    }


    private static final NoteRepositoryImpl SINGLETON = new NoteRepositoryImpl();

    private NoteRepositoryImpl() {}

    public static NoteRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public void save(Note note) {
        NOTES.add(note);
        flush();
    }

    @Override
    public Set<Note> findAll() {
        return NOTES;
    }

    @Override
    public void remove(Note note) {
        NOTES.remove(note);
        flush();
    }

    private static  void flush(){
        saveDataToFile();
    }

    //работа с файлами
    @SuppressWarnings("unchecked")
    private static void loadDataToFile() {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(DATA_FILE_NAME))){

            Set<Note> loadedNotes = (Set<Note>) stream.readObject();
            NOTES.addAll(loadedNotes);
        }catch (FileNotFoundException ex){
            System.out.println("oops");

            // nothing.
        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private static void saveDataToFile() {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME))){

            stream.writeObject(NOTES);

        }catch (FileNotFoundException ex){
            System.out.println("oops");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
