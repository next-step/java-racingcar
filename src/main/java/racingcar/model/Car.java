package racingcar.model;

import java.util.Random;

public class Car {

    static final int RUN_CONDITION = 4;
    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    private int position = 0;
    private String name = "";

    public Car() {
    }

    public Car(String name) {
        if(name.length() > CAR_NAME_LENGTH_LIMIT){
            throw new RuntimeException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
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
