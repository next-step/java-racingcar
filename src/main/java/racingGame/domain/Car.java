package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final int TRANSFER_UNIT = 1;
    private final int REFERENCE_VALUE = 4;

    private String name;
    private int position;
    private List<Integer> recode;

    public Car(String name) {
        this.position = 0;
        this.name = name;
        this.recode = new ArrayList<>();
    }

    public int getPosition() {
        return position;
    }

    public int getPosition(int i) {
        return this.recode.get(i);
    }

    public void move(boolean isMove) {
        if (isMove) {
            this.position += TRANSFER_UNIT;
        }
    }

    public boolean isMoveCar(int randomNumber) {
        return randomNumber > REFERENCE_VALUE;
    }

    public void nextRace(Number randomNumber) {
        boolean isMoveCar = this.isMoveCar(randomNumber.acceleratorNumber());
        this.move(isMoveCar);
        this.recode.add(this.getPosition());
    }

    public String getName() {
        return this.name;
    }

    public boolean isWinner(int winPosition) {
        return getPosition() == winPosition;
    }
}
