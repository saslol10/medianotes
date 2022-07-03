package src.command.executor;

import src.model.Note;
import src.command.CommandType;

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
        for (Note note : noteRepository.findAll()) {
//            System.out.println(String.format("Title: \"%s\". Text: \"%s\"", note.getTitle(), note.getText()));
            var path = findFolderPath(note.getName());

            System.out.printf("Title: \"%s\". Text: \"%s\". FullPath: %s %n ",
                    note.getName(),
                    note.getText(),
                    path);
        }

        return 1;
    }
}
