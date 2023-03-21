package racingcar;

import java.util.Random;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private Name name;

    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() { return name.toString(); }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (getMoveCondition() > MOVE_CONDITION) {
            position++;
        }
    }

    public void move(int number) {
        if (number > MOVE_CONDITION) {
            position++;
        }
    }

    private int getMoveCondition() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public String toString() {
        return name.toString() + " : " + position;
    }
}
