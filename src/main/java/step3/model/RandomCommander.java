package step3.model;

import java.util.Random;

public class RandomCommander implements Commander {

    private Random random = new Random();

    @Override
    public boolean moveForward() {
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

}

