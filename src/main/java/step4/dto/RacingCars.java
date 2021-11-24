package step4.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(List<String> carsName) {
        racingCars = new ArrayList<>();

        carsName.forEach(name -> {
            racingCars.add(new Car(new CarName(name)));
        });
    }

    public void moveRacingCars(RunStrategy runStrategy) {
        racingCars.forEach(car -> {
            car.run(runStrategy);
        });
    }

    public List<Car> currentCars() {
        return racingCars.stream()
                .map(car -> new Car(car))
                .collect(Collectors.toList());
    }
}
