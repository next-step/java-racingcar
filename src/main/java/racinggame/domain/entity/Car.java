package racinggame.domain.entity;

import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Location;

public class Car {
    private final String name;
    private Location location;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 다섯 글자를 넘길 수 없습니다.");
        }
        this.name = name;
        this.location = new Location(0);
    }

    public Location play(MovingStrategy movingStrategy) {
        Boolean moved = movingStrategy.run();
        if (moved) {
            location = location.forward();
        }
        return location;
    }

    public void report(ReportingCar reportingCar) {
        reportingCar.report(this);
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public interface ReportingCar {
        void report(Car car);
    }
}
