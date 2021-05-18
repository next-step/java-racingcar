package racingcar;

import java.util.Random;

public class ActionCar {
    public int action = 0;

    public int run(int random) {

        if (random >= 4) {
            action++;
        }
        return action;
    }

    public int random() {

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }
}
