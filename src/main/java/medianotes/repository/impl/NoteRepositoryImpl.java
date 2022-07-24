package medianotes.repository.impl;

import lombok.SneakyThrows;
import medianotes.config.ApplicationDataSource;
import medianotes.model.Note;
import medianotes.repository.NoteRepository;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import java.util.Objects;
import java.util.Set;


public class NoteRepositoryImpl implements NoteRepository {


    private static final NoteRepositoryImpl SINGLETON = new NoteRepositoryImpl();

    private NoteRepositoryImpl() {}

    public static NoteRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Note> findAll() {
       try(var st = ApplicationDataSource.getConnection()
               .prepareStatement("select * from note")){
                var result = st.executeQuery();

                return mapResultSetToNotes(result);

       }catch(SQLException e){
           throw new RuntimeException();
       }
    }

    @SneakyThrows
    private static Set<Note> mapResultSetToNotes(ResultSet resultSet){
        Set<Note> notes = new HashSet<>();

        while (resultSet.next()){
            var id = resultSet.getInt("id");
            var name = resultSet.getString("name");
            var text = resultSet.getString("text");
            var authorEmail = resultSet.getString("authorEmail");

            notes.add(new Note(
                    id,
                    name,
                    text,
                    null,//надо поменять
                    authorEmail
            ));
        }
        return notes;
    }

    @Override
    public void save(Note note) {
        //todo.
    }

    @Override
    public void remove(Note note) {
        //todo.
    }

}
