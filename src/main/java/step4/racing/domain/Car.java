package step4.racing.domain;

import java.util.Objects;

public class Car {
    private String name;
    private int posiotion;
    private static final String POSITION_VALID_MSG = "위치는 0 보다 커야 합니다.";
    private static final int START_POSITION = 0;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int posiotion) {
        this.name = name;
        this.posiotion = posiotion;
    }

    public void moveCarPosition() {
        this.posiotion++;
    }

    public String getName() {
        return name;
    }

    public int getPosiotion() {
        return posiotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return posiotion == car.posiotion &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, posiotion);
    }
}
