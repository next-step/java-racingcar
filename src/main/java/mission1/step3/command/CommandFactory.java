package mission1.step3.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandFactory {

    private static final Random RANDOM =  new Random();

    private CommandFactory(){}

    public static List<Command> createCommandList(int execNumber) {
        List<Command> commandList = new ArrayList<>();

        for (int i = 0; i < execNumber; i++) {
            commandList.add(getCommand(getRandomValue()));
        }

        return commandList;
    }

    public static Command getCommand(int randomValue) {
        if (randomValue >= 4) {
            return Command.GO;
        }

        return Command.STOP;
    }

    private static int getRandomValue() {
        return RANDOM.nextInt(10);
    }
}
