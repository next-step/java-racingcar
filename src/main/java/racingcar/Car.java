package racingcar;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class Car {
    private static final int MOVE_MIN_NUM = 4;

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
        if (position < 0) {
            throw new RuntimeException("1이상의 숫자만 가능합니다.");
        }
        return position;
    }


}
