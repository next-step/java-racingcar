package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    public List<Integer> moveCar(int moveCnt) {

        List<Integer> moveList = new ArrayList<>();

        for (int i = 0; i < moveCnt; i++) {
            moveList.add(getMoveCount());
        }

        return moveList;
    }

    private int getMoveCount() {
        if (isMoved()) {
            return 1;
        }

        return 0;
    }

    private boolean isMoved() {

        Random random = new Random();

        return random.nextInt(10) > 4;

    }
}
