package racinggame.mvc.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private int position;

    public Car(CarName name, int position) {
        this.name = Objects.requireNonNull(name);
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다.");
        }

        this.position = position;
    }

    public Car(String name, int position) {
        this(new CarName(name), position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move(int threshold) {
        if (threshold < 4) {
            return;
        }

        position++;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position;
    }
}
