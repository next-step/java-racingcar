package study.step4.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_NUMBER = 4; // 매직넘버 상수화
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int maxPosition() {
        return position;
    }

    public Car move(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            position++;
        }
        return new Car(this.name, this.position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
