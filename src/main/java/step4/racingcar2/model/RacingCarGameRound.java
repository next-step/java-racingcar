package step4.racingcar2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step4.racingcar2.exception.RacingCarGameRoundException;

public class RacingCarGameRound {

    private final List<RacingCar> cars;

    public RacingCarGameRound(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> cars() {
        return this.cars;
    }

    public void start() {
        for (RacingCar car : cars) {
            car.run();
        }
    }

    public List<RacingCar> winners() {
        int maxPosition = cars.stream().mapToInt(RacingCar::position).max().orElseThrow(() -> new RacingCarGameRoundException(""));
        return cars.stream().filter(car -> car.position() == maxPosition)
            .collect(Collectors.toCollection(ArrayList::new));
    }


}
