package racingcar.car;

import java.text.MessageFormat;

public class Car {

    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;
    private final int MIN_MOVE_NUMBER = 4;
    private final String name;
    private int score = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, "-".repeat(score));
    }

    public void move(int random) {
        if (random >= MIN_MOVE_NUMBER) {
            this.score++;
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름이 유효하지 않습니다");
        }
    }
}
