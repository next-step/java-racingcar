package racingcar.domain.car;

import racingcar.dto.Result;
import racingcar.dto.Results;
import racingcar.dto.Winner;
import racingcar.dto.Winners;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final String value) {
        CarNames carNames = new CarNames(value);
        this.cars = generateCars(carNames.getParsed());
    }

    private List<Car> generateCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public void move() {
        for (Car car : cars) {
            car.move(generateRandom());
        }
    }

    private int generateRandom() {
        return (int) (Math.random() * 10000) % 10;
    }

    public Winners findWinners() {
        int maxScore = getMaxScore();
        List<Winner> winners = cars.stream()
                .filter(car -> car.isSameScore(maxScore))
                .map(car -> new Winner(car.getName()))
                .collect(Collectors.toList());
        return new Winners(winners);
    }

    private int getMaxScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);
    }

    public Results findAll() {
        List<Result> results = cars.stream()
                .map(car -> new Result(car.getName(), car.getScore()))
                .collect(Collectors.toList());
        return new Results(results);
    }
}
