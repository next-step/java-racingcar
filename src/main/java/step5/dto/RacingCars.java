package step5.dto;

import step5.dto.strategy.RunStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(CarNames carNames) {
        racingCars = new ArrayList<>();

        carNames.getCarNameGroup().forEach(name -> {
            racingCars.add(new Car(name));
        });
    }

    public void moveRacingCars(RunStrategy runStrategy) {
        racingCars.forEach(car -> {
            car.run(runStrategy);
        });
    }

    public List<Car> currentCars() {
        return racingCars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
