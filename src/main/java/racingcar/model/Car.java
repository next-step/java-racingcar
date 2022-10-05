package racingcar.model;

import racingcar.model.nickname.Nickname;

import java.util.Objects;

public class Car {

    private final Nickname nickname;
    private Position position;

    public Car(String nickname) {
        this(new Nickname(nickname));
    }

    public Car(Nickname nickname) {
        this.position = new Position();
        this.nickname = nickname;
    }

    public Car(Nickname nickname, Position position) {
        this.nickname = nickname;
        this.position = position;
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
