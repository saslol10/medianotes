package src.command.executor;

import src.Note;
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
            System.out.printf("Title: \"%s\". Text: \"%s\"%n", note.getName(), note.getText());
        }

        return 1;
    }
}
