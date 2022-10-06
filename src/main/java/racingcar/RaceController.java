package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final RaceInput raceInput;
    private int currentRound;
    private final List<Car> cars;

    public RaceController(RaceInput raceInput) {
        cars = new ArrayList<>();
        currentRound = 1;
        this.raceInput = raceInput;
        for (int i = 0; i < raceInput.getNumberOfCar(); i++) {
            this.cars.add(new Car());
        }
    }

    public void doRaceRound() {
        currentRound++;
        cars.forEach(Car::race);
        System.out.println();
    }

    public void startRacing() {
        while (currentRound <= raceInput.getTryCount()) {
            doRaceRound();
        }
    }
}
