package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class Car {
    private static final int MOVE_MIN_NUM = 4;
    private static final int MIN_POSITION = 0;
    private final String carName;

    private int position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = positionValidCheck(position);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int num) {
        if (num >= MOVE_MIN_NUM) {
            position++;
        }
    }

    private int positionValidCheck(int position) {
        if (position < MIN_POSITION) {
            throw new RuntimeException("유효한 자동차 위치 값이 아닙니다.");
        }
        return position;
    }


}
