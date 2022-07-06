package medianotes.command.executor;

import medianotes.command.CommandType;

public interface CommandExecutor {


    int execute(String command);

    CommandType getCommandType();
}
