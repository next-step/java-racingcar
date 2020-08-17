package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandFactory {

    private static final Random random =  new Random();
    private int execNumber;

    private CommandFactory() {}

    public CommandFactory getInstance() {

    }

    public static List<Command> createCommandList(int execNumber) {
        List<Command> commandList = new ArrayList<>();

        for (int i = 0; i < execNumber; i++) {
            commandList.add(getCommand());
        }

        return commandList;
    }

    private static Command getCommand() {
        int randomValue = random.nextInt(10);

        if (randomValue >= 4) {
            return Command.GO;
        }

        return Command.STOP;
    }
}
