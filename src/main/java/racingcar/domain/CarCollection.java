package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CarCollection {

    private List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy.move());
        }
    }

    public String getWinner() {
        int winnerPosition = getMaxPosition(cars);
        List<String> winners = winner(winnerPosition);
        StringJoiner result = new StringJoiner(", ");
        winners.forEach(result::add);

        return result + "가 최종 우승했습니다.";
    }

    private List<String> winner(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.position() == winnerPosition)
                .map(Car::name).collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(0);
    }
}
