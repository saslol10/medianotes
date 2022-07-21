package medianotes.command.executor;

import medianotes.context.UserContext;
import medianotes.model.Note;
import medianotes.command.CommandType;

import java.util.Comparator;
import java.util.stream.Collectors;

public class NoteWriter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return writeNotes(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_NOTES;
    }

    private int writeNotes(String command) {

        var notes = noteRepository.findAll()
                .stream()
                .toList();

        //фильтрация и сортировка
        var isNeedsFiltering = command.contains("-f");
        var isNeedsSorting = command.contains("-s");

        var userEmail = UserContext.getUserLogin();

        if(isNeedsFiltering){
            notes = notes
                    .stream()
                    .filter(note-> note.getAuthorEmail().equals(userEmail))
                    .collect(Collectors.toList());
        }
        if(isNeedsSorting){
            notes = notes
                    .stream()
                    .sorted(Comparator.comparing(Note::getCreationDate))
                    .collect(Collectors.toList());
        }


        for (Note note : notes) {
//            System.out.println(String.format("Title: \"%s\". Text: \"%s\"", note.getTitle(), note.getText()));
            var path = findFolderPath(note.getName());

            System.out.printf("Title: \"%s\". Text: \"%s\". FullPath: %s %n",
                    note.getName(),
                    note.getText(),
                    path);
        }

        return 1;
    }
}
