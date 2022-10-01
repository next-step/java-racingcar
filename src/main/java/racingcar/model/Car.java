package racingcar.model;

import racingcar.model.nickname.Nickname;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {

    private final Nickname nickname;
    private final Position position;

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
            position.moveForward();
        }
    }

    public static List<Car> getWinner(List<Car> cars) {
        Position biggestPosition = Position.biggestPosition(mapToPosition(cars));
        return cars.stream()
                .filter(car -> car.position.greaterThanOrEqual(biggestPosition))
                .collect(Collectors.toList());
    }

    private static List<Position> mapToPosition(List<Car> cars) {
        return cars.stream()
                .map(c -> c.position)
                .collect(Collectors.toList());
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
