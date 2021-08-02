package CarRacing;

import java.util.Random;

public class RandomMove implements MovigStrategy {


    @Override
    public boolean moveAble() {
        return randomNumber() >= 4;
    }

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
