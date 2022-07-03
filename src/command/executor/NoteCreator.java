package src.command.executor;

import src.Note;
import src.command.CommandType;
import src.repository.impl.NoteRepositoryImpl;

public class NoteCreator extends AbstractCommandExecutor {



    @Override
    public int execute(String command) {
        return createNote(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_NOTE;
    }

    private static int createNote(String command) {
        //String.split("string") - делит строку по заданной строке
        String[] wordsArray = command.split(" ");

        String noteName = wordsArray[2];

        /*
        String noteText = "";
        // for (String word : words) {} //проход по каждому элементу массива
        for (int i = 3; i < words.length; i++) {
            noteText = noteText + words[i];
        }
        // Подобная конструкция сгенерирует в String pool много строк,
        // что засоряет память => переход к StringBuilder
        */

        if (findNote(noteName).isPresent()) {
            System.out.println("Note already exists");
            return -1;
        }

        StringBuilder noteTextSb = new StringBuilder();
        for (int i = 3; i < wordsArray.length; i++) {
            noteTextSb.append(wordsArray[i]);
            noteTextSb.append(" ");//костыль - добавка пробела
        }
        String noteText = noteTextSb.toString();

        //Вызвать репозиторий и добавить туда новый объект
        Note newNote = new Note(noteName, noteText);
        noteRepository.save(newNote);

        System.out.println("New note created");

        return 1;
    }

}
