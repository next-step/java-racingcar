package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final int MOVE_CONDITION = 4;

    private List<Integer> carPositions = new ArrayList<>();
    private int position = 0;

    public void move() {
        if (isMovable(getRandom())) {
            // TODO: 랜덤 숫자가 작을 때는 position을 저장하지 않는 문제.
            carPositions.add(++position);
        }
    }

    // TODO: private 메소드 단위 테스트 고민.
    private int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_BOUND);
    }

    private boolean isMovable(int value) {
        return value >= MOVE_CONDITION;
    }

}
