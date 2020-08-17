package racing.core.domain;

import racing.core.patterns.MoveStrategy;
import racing.core.dto.TrackInfo;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public TrackInfo move(MoveStrategy movement) {
        if (movement.canMove()) {
            position++;
        }
        return new TrackInfo(name, position);
    }
}
