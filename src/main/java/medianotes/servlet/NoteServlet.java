package medianotes.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import medianotes.dto.NoteCreateDto;
import medianotes.helper.ObjectMapperHelper;
import medianotes.model.Note;
import medianotes.repository.NoteRepository;
import medianotes.repository.impl.NoteRepositoryImpl;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/notes")
public class NoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        var body = req.getReader().lines().collect(Collectors.joining());
        var bodyAsDto = ObjectMapperHelper.readValue(body, NoteCreateDto.class);

        var newNote = new Note(
                bodyAsDto.getTitle(),
                bodyAsDto.getText(),
                null,
                bodyAsDto.getAuthorEmail()
        );
        NoteRepositoryImpl.getSingleton().save(newNote);


    }




}
