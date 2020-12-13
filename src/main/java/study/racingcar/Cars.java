package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final Random random = new Random();

    public Cars(int racingParticipantNo) {
        for (int i = 0; i < racingParticipantNo; i++) {
            this.cars.add(new Car());
        }
    }

    public RacingResult getResult() {
        RacingResult racingResult = new RacingResult(cars);
        this.cars.forEach(racingResult::addResult);
        return racingResult;
    }

    public void moveAll() {

        cars.forEach(car -> car.move(random.nextInt() % 10));
    }

    public void moveAll(int randomNo) {

        cars.forEach(car -> car.move(randomNo));
    }
}
