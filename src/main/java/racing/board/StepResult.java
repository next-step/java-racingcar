package racing.board;

import racing.model.NamedRacingCar;
import racing.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class StepResult {

    private List<RacingCar> cars;

    public StepResult(List<RacingCar> cars) {
        this.cars = copyCars(cars);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    private List<RacingCar> copyCars(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> new NamedRacingCar(car))
                .collect(Collectors.toList());
    }
}
