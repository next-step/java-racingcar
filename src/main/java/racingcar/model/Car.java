package racingcar.model;

import java.util.Random;

public class Car {

    static final int RUN_CONDITION = 4;

    private int position = 0;
    private String name = "";

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(int value) {
        if (goOrStop(RUN_CONDITION, value)) {
            plugPosition();
        }
    }

    public void plugPosition() {
        this.position += 1;
    }

    public boolean goOrStop(int condition, int value) {
        return value >= condition;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {return this.name;}


}
