package racingcar.service;

import java.util.Random;

public class MoveService {

    public String isMove() {
        Random random = new Random();
        int number = random.nextInt(10);
        if (number >= 4) {
            return "1";
        }
        return "0";
    }

    public boolean isMovable() {
        return new Random().nextInt(10) >= 4;
    }
}
