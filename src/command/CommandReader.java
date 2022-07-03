package src.command;

import src.command.executor.CommandExecutor;
import src.command.executor.NoteCreator;
import src.command.executor.NoteDeleter;
import src.command.executor.NoteWriter;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {


    // Map.of - метод, позволяющий инициализировать мапу сразу с данными в ней.
    // Ключем в этой мапе выступает CommandType, то есть какая-то команда (создание заметки, ее удаление, и тп).
    // Значением выступает обработчик этой команды.

    // Таким образом, можем за О(1) найти обработчик по команде. Не то что бы это сильно быстрее, чем просто перебрать все обработчики за О(n)
    // при таком количестве обработчиков :)

    // Рекомендую почитать подробнее про внутреннюю работу HashMap, TreeMap и тп.

    private static final Map<CommandType, CommandExecutor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.of(
            CommandType.CREATE_NOTE, new NoteCreator(),
            CommandType.DELETE_NOTE, new NoteDeleter(),
            CommandType.WRITE_ALL_NOTES, new NoteWriter()
    );

    public static void startReading() {
        System.out.println("Program started! Write your command:");
        Scanner s = new Scanner(System.in);

        //бесконечный цикл
        int i = 1;
        while (i != 0) {
            i = readCommand(s);
        }
        s.close();
    }

    /**
     * Available commands:
     * - "create note note-name note text", note-name - only 1 word, note text - 1 or more words;
     * - "delete note note-name";
     * - "notes" - to view all notes.
     */

    //статический метод для чтения команд с консоли
    private static int readCommand(Scanner s) {

        var commandString = s.nextLine();

        CommandType commandType = getCommandType(commandString); // достаем из строки команду.

        if (COMMAND_EXECUTORS_GROUPED_BY_COMMAND.containsKey(commandType)) { // проверяем, есть ли обработчик этой команды в мапе по ключу.
            var commandExecutor = COMMAND_EXECUTORS_GROUPED_BY_COMMAND.get(commandType); // если есть, то достаем обработчик по ключу
            return commandExecutor.execute(commandString); // и выполняем команду
        }

        if (commandType == CommandType.EXIT) {
            return 0;
        }

        System.out.println("Incorrect command");
        return -1;

    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("create note")) {
            return CommandType.CREATE_NOTE;
        }

        if (commandString.contains("delete note")) {
            return CommandType.DELETE_NOTE;
        }

        if (commandString.contains("notes")) {
            return CommandType.WRITE_ALL_NOTES;
        }

        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }

        return CommandType.UNDEFINED;

        //String.contains("") - метод определяет содержится ли в строке заданная строка
       /* if (command.contains("create note")) {
            return new NoteCreator().execute(command);
        }
        if (command.contains("notes")) {
            return viewAllNotes(command);
        }
        if (command.contains("remove note")) {
            return removeNote(command);
        }

        if (command.contains("exit")) {
            return 0;//Завершить программу
        }
        return -1;//Команда не найдена*/
    }




    /*
    private static int viewAllNotes(String command) {
        var notes = noteRepository.getAllNotes();

        //printf - print format - шаблон текста
        // %s - подстановка значения (через запятую)
        // /n, /r  - символ переноса строки
        for (var note : notes) {
            System.out.printf("Название: %s, Текст: %s, Автор: %ы /n",
                    note.getName(),
                    note.getText(),
                    note.getAuthor()
            );
        }

        return 1; //Код 1 - все хорошо.
    }

    private static int removeNote(String command) {
        String[] words = command.split(" ");
        String noteName = words[3];
        noteRepository.remove(noteName);
        return 1;
    }*/

}