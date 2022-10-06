package racingcar.model;

import racingcar.model.nickname.Nickname;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Nickname nickname;
    private Position position;

    public Car(Nickname nickname, Position position) {
        this.nickname = nickname;
        this.position = position;
    }

    public Car(Nickname nickname) {
        this(nickname, new Position());
    }

    public Car(String nickname) {
        this(new Nickname(nickname));
    }

    void move(Condition carCondition) {
        if (carCondition.inspect()) {
            position = position.moveForward();
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public String getName() {
        return nickname.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(nickname, car.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, nickname);
    }
}
