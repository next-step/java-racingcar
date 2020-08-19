package racing.core.domain;

import racing.core.dto.TrackInfo;
import racing.core.exception.ErrorMessage;
import racing.core.patterns.MoveStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int LENGTH_LIMIT = 5;

    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_VALUE.getMessage());
        }
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER.getMessage());
        }
    }

    public TrackInfo move(MoveStrategy movement) {
        if (movement.canMove()) {
            position++;
        }
        return new TrackInfo(name, position);
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }
}
