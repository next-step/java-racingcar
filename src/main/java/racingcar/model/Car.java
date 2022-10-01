package racingcar.model;

import racingcar.model.nickname.Nickname;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final Position position;
    private final Nickname nickname;

    public Car(String nickname) {
        this(new Nickname(nickname));
    }

    public Car(Nickname nickname) {
        this.position = new Position();
        this.nickname = nickname;
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
}
