package medianotes.command;

import medianotes.command.executor.*;

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
            CommandType.WRITE_ALL_NOTES, new NoteWriter(),
            CommandType.CREATE_FOLDER, new FolderCreator()
    );

    public static void startReading() {
        System.out.println("Program started! Write your command: ");
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

        if (commandString.contains("create folder")) {
            return CommandType.CREATE_FOLDER;
        }

        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }

        return CommandType.UNDEFINED;
    }
}
