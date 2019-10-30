package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private final static int START_POSITION = 0;
    private final static int RANDOM_BOUND = 10;
    private final static int RANDOM_BASE = 3;

    private List<Integer> positions = new ArrayList<>();


    public void move() {
        int position = START_POSITION;

        if (isNotFirstRound()) {
            int latestRound = positions.size();
            position = getCarPosition(latestRound - 1);
        }

        if (getRandom() > RANDOM_BASE) {
            position++;
        }

        positions.add(position);
    }

    public int getCarPosition(int roundNum) {
        return positions.get(roundNum);
    }

    private boolean isNotFirstRound() {
        if (positions.size() > 0) {
            return true;
        }
        return false;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }


}
