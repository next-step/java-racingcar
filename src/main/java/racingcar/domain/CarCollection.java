package racingcar.domain;

import racingcar.strategy.MoveStrategy;
import racingcar.validite.ValidityCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CarCollection {

    private List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void participants(List<String> carNames) {
        ValidityCheck.carNameCheck(carNames);
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy.move());
        }
    }

    public String getWinner() {
        int winnerPosition = getMaxPosition(cars);
        List<String> winners = cars.stream()
                .filter(car -> car.position() == winnerPosition)
                .map(Car::name).collect(Collectors.toList());

        StringJoiner result = new StringJoiner(", ");
        winners.forEach(result::add);

        return result + "가 최종 우승했습니다.";
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대값이 없습니다."));
    }
}
