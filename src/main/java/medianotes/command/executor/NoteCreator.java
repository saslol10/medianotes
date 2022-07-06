package medianotes.command.executor;

import medianotes.model.Note;
import medianotes.command.CommandType;


public class NoteCreator extends AbstractCommandExecutor {



    @Override
    public int execute(String command) {
        return createNote(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_NOTE;
    }

    private int createNote(String command) {

        String[] wordsArray = command.split(" ");

        String noteName = wordsArray[2];

        if (findNote(noteName).isPresent()) {
            System.out.println("Note already exists");
            return -1;
        }

        var noteParentFolder = wordsArray[3];
        var folder = findFolder(noteParentFolder);

        if(folder.isEmpty()){
            System.out.println("Folder not exists");
            return - 1;
        }
        StringBuilder noteTextSb = new StringBuilder();
        for (int i = 4; i < wordsArray.length; i++) {
            noteTextSb.append(wordsArray[i]);
            noteTextSb.append(" ");//костыль - добавка пробела
        }
        String noteText = noteTextSb.toString();

        Note newNote = new Note(noteName, noteText, folder.get());
        noteRepository.save(newNote);

        System.out.println("New note created");

        return 1;
    }

}
