package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private Random random = new Random();

    @Override
    public boolean canMove() {
        int randomNumber = random.nextInt(10);
        return randomNumber >= 4;
    }
}
