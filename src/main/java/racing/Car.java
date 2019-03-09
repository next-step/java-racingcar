package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private final int LIMIT_VALUE = 4;

    private List<Integer> moveList;

    public void move(int moveCnt) {

        moveList = new ArrayList<>();

        for (int i = 0; i < moveCnt; i++) {
            int randomValue = getRandomValue();
            moveList.add(getMoveCount(randomValue));
        }

    }

    public int getMoveCount(int randomValue) {
        if (randomValue > LIMIT_VALUE) {
            return 1;
        }

        return 0;
    }

    public int getRandomValue() {

        return new Random().nextInt(10);

    }

    public List<Integer> getMoveList() {
        return moveList;
    }
}
