package racingcar.domain.move;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    final private int baseLineNum = 4;

    @Override
    public boolean canMove() {
        int randomNumber = makeRandomNumber();

        return randomNumber >= baseLineNum;
    }

    public int makeRandomNumber(){
        Random random = new Random();
        return random.nextInt(10);

    }
}
