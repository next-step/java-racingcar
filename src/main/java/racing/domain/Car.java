package racing.domain;

import org.apache.commons.lang3.StringUtils;
import racing.utils.MovingStrategy;

public class Car {

    private final String name;

    private int distance;

    public Car(final String name) {
        checkName(name);
        this.name = name;
        this.distance = 0;
    }

    public Car(final String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.distance++;
        }
    }

    public boolean isWinner(int maxMove) {
        return this.distance == maxMove;
    }

    private void checkName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalStateException("자동차 이름 값은 존재해야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

}
