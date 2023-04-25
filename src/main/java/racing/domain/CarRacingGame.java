package racing.domain;


import racing.util.RandomGenerator;

import java.util.ArrayList;
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
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }

    private void validHasEnoughCars() {
        this.cars.canStartRace();
    }

    public void doRound() {
        List<Car> carList = this.cars.deepCopyCarList();
        for (Car car : carList) {
            car.move(RandomGenerator.generate(10));
        }
        this.cars = new Cars(carList);
    }

    public Cars result() {
        return this.cars; // 불변이 보증되어 있어 참조형이어도 그대로 응답가능
    }
}