package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    static final int START_POSITION = 0;
    static final int FIRST_ROUND = 0;

    private List<Integer> positions = new ArrayList<>();
    private String name;


    public Car(String name) {
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        int position = getLatestPosition();

        if (moveStrategy.isMove()) {
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


}
