package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private int currentRound;
    private final int tryCount;
    private final List<Car> cars;

    public RaceController(List<Car> cars, int tryCount) {
        currentRound = 1;
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void doRaceRound() {
        currentRound++;
        cars.forEach(Car::race);
        RaceView.printCars(cars);
    }

    public void startRacing() {
        System.out.println("실행 결과");
        while (currentRound <= this.tryCount) {
            doRaceRound();
        }
    }
}
