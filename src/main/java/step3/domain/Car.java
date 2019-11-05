package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private final static int SUM_INIT_NUMBER = 0;
    private final static int POSITION_CHECK_NUMBER = 1;
    private final static int RANDOM_NUMBER_RANGE = 10;
    private final static int PIVOT = 4;
    private final static int MOVING = 1;
    private final static int STOP = 0;
    private String name;
    private List<Integer> position;

    public Car(String name) {
        this.name = name;
        this.position = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isPositionValue(int index) {
        return this.position.get(index) == POSITION_CHECK_NUMBER;
    }

    public boolean isWinner(int winnerPosition) {
        return currentPosition() == winnerPosition;
    }

    public int currentPosition() {
        int sum = SUM_INIT_NUMBER;
        for (Integer integer : position) {
            sum += integer;
        }
        return sum;
    }

    public int move(Movable movable) {
        if (movable.isMove()) {
            return MOVING;
        }
        return STOP;
    }

    public void updatePosition() {
        this.position.add(move(() -> getRandomNumber() >= PIVOT));
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_RANGE);
    }
}