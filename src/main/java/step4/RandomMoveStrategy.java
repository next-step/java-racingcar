package step4;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public int randomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    @Override
    public boolean isMove() {
        return randomNumber() >= 4;
    }
}
