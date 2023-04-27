package racing.domain;


import racing.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarRacingGame {

    private Cars cars;

    public CarRacingGame(String carNames) {
        List<String> names = parseNames(carNames);
        this.cars = initCars(names);
        validHasEnoughCars();
    }

    private List<String> parseNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());
    }

    private Cars initCars(List<String> names) {
        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    private void validHasEnoughCars() {
        this.cars.canStartRace();
    }

    public void doRound() {
        List<Car> carList = this.cars.deepCopyCarList();
        carList.forEach(car -> car.move(RandomGenerator.generate(10)));
        this.cars = new Cars(carList);
    }

    public Cars result() {
        return this.cars;
    }

    public Cars winners() {
        return this.cars.findWinners();
    }
}