package racingcar;

import java.util.Random;

public class Car {
    private static final int MAXIMUN_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_MINIMUM_POSITION = 4;
    private String name;
    private int position;


    public Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(final String name) {
        if (name.length() > MAXIMUN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5글자 넘으면안됨");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    public void move(final int condition) {
        if (condition >= MOVE_MINIMUM_POSITION) {
            position++;
        }
    }

}


