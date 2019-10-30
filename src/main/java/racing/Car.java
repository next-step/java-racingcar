package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    static final int START_POSITION = 0;
    static final int FIRST_ROUND = 0;
    static final int RANDOM_BOUND = 10;
    static final int RANDOM_BASE = 3;

    private List<Integer> positions = new ArrayList<>();
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int position = getLatestPosition();

        if (getRandom() > RANDOM_BASE) {
            position++;
        }

        positions.add(position);
    }

    public String getName() {
        return name;
    }

    public int getLatestPosition() {
        int latestRound = positions.size() - 1;
        if (isFirstRound(latestRound)) {
            return START_POSITION;
        }
        return getPosition(latestRound);
    }

    public int getPosition(int roundNum) {
        return positions.get(roundNum);
    }

    private boolean isFirstRound(int latestRound) {
        if (latestRound < FIRST_ROUND) {
            return true;
        }
        return false;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

}
