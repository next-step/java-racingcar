package racing.domain;

import racing.util.RandomNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANGE = 10;
    private List<RacingCar> racingCars = new ArrayList<>();
    private int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        this.tryCount = tryCount;
        this.createCars(carNames);
    }

    private void createCars(List<String> carNames) {
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName, 0));
        }
    }

    public List<RacingCar> playRacing() {
        this.racingCars.forEach(car -> {
            car.move(RandomNumberUtil.createRandomNumber(RANGE));
        });
        return this.racingCars;
    }

    public boolean isEnd() {
        return this.tryCount-- == 0;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
