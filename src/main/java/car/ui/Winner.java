package car.ui;

import car.domain.Car;
import car.domain.Name;

public class Winner {
    private Name name;

    private Winner(Name name) {
        this.name = name;
    }

    public static Winner from(Car car) {
        return new Winner(car.getName());
    }

    @Override
    public String toString() {
        return this.name.getName();
    }
}
