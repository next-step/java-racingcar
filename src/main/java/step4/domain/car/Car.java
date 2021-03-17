package step4.domain.car;

import step4.domain.car.name.Name;

public final class Car {

    private final Name name;
    private int position;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public final void move(int activation) {
        if (activation >= 4 && activation <= 9) {
            position++;
        }
    }

    public final int position() {
        return position;
    }

}
