package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private RacingCars racingCars;

    public Racing(String[] carNames) {
        racingCars = createRacingCar(carNames);
    }

    private RacingCars createRacingCar(String carNames[]) {
        List<RacingCar> racingCars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return new RacingCars(racingCars);
    }

    public RacingCars onceMove() {
        racingCars.randomMove();
        return racingCars;
    }

    public RacingCars getRacingCar() {
        return racingCars;
    }

    public String whoIsWin() {
        return racingCars.getWinnerName();
    }
}
