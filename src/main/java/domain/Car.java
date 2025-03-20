package domain;

import java.util.Random;
import view.ResultView;

public class Car {
    private int position = 0;
    private static final Random random = new Random();

    private int getRandomValue() {
        return random.nextInt(10);
    }

    private void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    private void viewCurrentPosition() {
        ResultView.printCurrentPosition(position);
    }

    public void run() {
        int randomValue = getRandomValue();
        move(randomValue);
        viewCurrentPosition();
    }
}