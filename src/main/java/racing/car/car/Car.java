package racing.car.car;

import java.util.Objects;

public class Car implements Movable {
    private final CarName name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    // 생성자에서 name을 반드시 받도록 강제
    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    @Override
    public void move(int number) {
        position = position.move(number);
    }

    public boolean isSame(int otherPosition) {
        return this.position.isSame(otherPosition);
    }

    public int max(int maxPosition) {
        return this.position.max(maxPosition);
    }

    public void draw(){
        name.draw();
        position.draw();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}

