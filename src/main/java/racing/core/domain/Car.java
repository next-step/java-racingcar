package racing.core.domain;

import racing.core.dto.TrackInfo;
import racing.core.patterns.MoveStrategy;

import java.util.Objects;

public class Car {

    private static final int LENGTH_LIMIT = 5;
    private String name;
    private int position;

    public Car(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 반드시 문자나 숫자를 포함해야 합니다.");
        }
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        return name;
    }

    public TrackInfo move(MoveStrategy movement) {
        if (movement.canMove()) {
            position++;
        }
        return new TrackInfo(name, position);
    }
}
