package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(String carNameText) {
        this.cars = new ArrayList<>();
        cars = createRacingCars(carNameText);
    }

    protected List<Car> createRacingCars(String carNameText) {
        return Arrays.stream(carNameText.split(",")).map(Car::new).collect(Collectors.toList());
    }

    public void race() {
        this.cars.forEach(Car::run);
    }

    public Winners pickWinners() {
        Collections.sort(cars);

        Car firstWinner = cars.get(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.compareTo(firstWinner) == 0)
                .collect(Collectors.toList());

        return new Winners(winners);
    }

}
