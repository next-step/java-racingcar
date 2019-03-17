package racingcar.view.web;

import java.util.List;
import racingcar.domain.RacingCar;

public class RaceResult {
    private String name;
    private List<RacingCar> cars;

    public RaceResult(String name, List<RacingCar> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}
