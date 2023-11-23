package step5.domain;

import step5.model.enums.StandardNumber;

import java.util.Random;

public class Referee {
    public boolean judgeToMove() {
        Random random = new Random();
        return random.nextInt(10) > StandardNumber.CAR_MOBILITY_STANDARD.number();
    }
}
