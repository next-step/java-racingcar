package step4.domain.car;

import step4.domain.car.name.Name;

public final class Car {

    private final Name name;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        this.name = name;
    }


}
