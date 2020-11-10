package racingcar.application;

import racingcar.application.number.NumberGenerator;
import racingcar.domain.Car;
import racingcar.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class RacingSimulator {

    private final NumberGenerator numberGenerator;
    private final ResultView resultView = new ResultView();

    public RacingSimulator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<String> getWinnersNames(List<Car> cars) {
        Optional<Car> winner = cars.stream()
                .max(Comparator.comparing(Car::getDistance));

        if (!winner.isPresent()) {
            throw new IllegalArgumentException("winner is not exists");
        }

        int maxDistance = winner.get().getDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public void race(List<Car> cars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            moveCars(cars);
            resultView.printDistanceOfCar(cars);
        }
    }
}
