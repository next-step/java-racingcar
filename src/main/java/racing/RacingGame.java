package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANGE = 10;
    private static final String SEPARATOR = ",";
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String carNames) {
        this.createCars(carNames);
    }

    private void createCars(String carNames) {
        for (String carName : carNames.split(SEPARATOR)) {
            this.racingCars.add(new RacingCar(carName, 0));
        }
    }

    protected void playRacing() {
        this.racingCars.forEach(car -> {
            car.move(RandomNumberUtil.createRandomNumber(RANGE));
        });
    }

    protected List<RacingCar> getRacingCar() {
        return this.racingCars;
    }
}
