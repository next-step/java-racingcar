package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private final int tryTime;
    private List<RacingCar> racingCars;

    public Racing(int carNum, int tryTime) {
        racingCars = createRacingCar(carNum);
        this.tryTime = tryTime;
    }

    private List<RacingCar> createRacingCar(int carNum) {
        List<RacingCar> racingCars = new ArrayList<>(carNum);
        for (int i = 0; i < carNum; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }

    public void startRace() {
        for (int i = 0; i < tryTime; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        racingCars.forEach(car -> {
            int randomNumber = RandomUtils.generateRandomNum();
            car.move(() -> car.isMove(randomNumber));
        });
    }

    public List<RacingCar> getRacingCar() {
        return Collections.unmodifiableList(racingCars);
    }
}
