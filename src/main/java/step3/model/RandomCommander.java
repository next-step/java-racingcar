package step3.model;

import java.util.Random;

public class RandomCommander {

    private Random random = new Random();

    private static final String FORWARD_COMMAND = "-";
    private static final String STOP_COMMAND = "";

    public String generateCommand() {
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            return FORWARD_COMMAND;
        }
        return STOP_COMMAND;
    }

}

