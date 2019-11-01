package racing;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    static final int RANDOM_BOUND = 10;
    static final int MOVE_BASE = 3;


    private Random random = new Random();


    @Override
    public boolean isMove() {
        return checkRandomNum(generateRandomNum());
    }

    private boolean checkRandomNum(int randomNum) {
        return (randomNum > MOVE_BASE) ? true : false;
    }

    private int generateRandomNum() {
        return random.nextInt(RANDOM_BOUND);
    }


}
