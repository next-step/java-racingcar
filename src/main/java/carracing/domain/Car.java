package carracing.domain;


import java.util.Objects;

public class Car {

    private String name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this(name, new Position(position));
    }

    public Car(final String name, final Position position) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다");
        }
        this.name = name.trim();
        this.position = position;
    }

    public boolean checkHasPosition(int position) {
        return this.position.checkHasPosition(position);
    }

    public int getBiggerPosition(int position) {
        return this.position.getBiggerPosition(position);
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position = position.increase();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
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
}
