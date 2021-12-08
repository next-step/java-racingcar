package racinggame.domain.entity;

import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Location;

public class Car {
    private Location location;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 다섯 글자를 넘길 수 없습니다.");
        }
        this.location = new Location(name, 0);
    }

    public Location play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        if (moved) {
            location = location.forward();
        }
        return location;
    }
}
