package racingcar.model;

import racingcar.model.nickname.Nickname;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private static final int START_POSITION = 0;

    private int position = START_POSITION;
    private final Nickname nickname;

    public Car(String nickname) {
        this.nickname = new Nickname(nickname);
    }

    public void move(Condition carCondition) {
        if (carCondition.inspect()) {
            this.position = position + 1;
        }
    }

    public static List<Car> getWinner(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.position >= getBiggestPosition(cars))
                .collect(Collectors.toList());
    }

    private static int getBiggestPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.position)
                .max()
                .orElse(START_POSITION);
    }

    public String getName() {
        return nickname.getValue();
    }

    public int getPosition() {
        return position;
    }
}
