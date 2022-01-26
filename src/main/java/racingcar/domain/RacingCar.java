package racingcar.domain;

import java.util.Collections;

public class RacingCar {

    private static final int THRESHOLD = 4;
    private static final int NAME_SIZE = 5;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value >= THRESHOLD) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    private void validateNameSize(String name) {
        if (name.length() > NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과했습니다!");
        }
    }

    @Override
    public String toString() {
        return String.join(name + " : ", Collections.nCopies(position, "-"));
    }
}