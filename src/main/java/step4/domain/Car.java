package step4.domain;

import org.apache.commons.lang3.ObjectUtils;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public boolean isInitialPositionZero(Car car) {
        return ObjectUtils.equals(car.position, new Position());
    }


}
