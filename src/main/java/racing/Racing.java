package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.Utils.generateRandomNum;

public class Racing {
    private int tryTime;
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
        for(int i = 0; i < tryTime; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for(RacingCar racingCar: racingCars) {
            int random = generateRandomNum();
            racingCar.move(random);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
