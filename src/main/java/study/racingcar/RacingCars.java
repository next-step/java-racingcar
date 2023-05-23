package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();
    private List<RacingCar> winners = new ArrayList<>();

    private int maxLocationCount = 0;

    public RacingCars() {
    }

    public RacingCars(List<RacingCar> racingCarsList) {
        this.racingCars = racingCarsList;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
    public List<RacingCar> getWinners() {
        return winners;
    }

    public void settingRacingCars(String[] carNames) {
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName));
        }
    }

    public void settingWinner(RacingCar racingCar) {
        if (racingCar.getForwardCount() > maxLocationCount) {
            maxLocationCount = racingCar.getForwardCount();
            winners.clear();
            winners.add(racingCar);
        } else if (racingCar.getForwardCount() == maxLocationCount) {
            winners.add(racingCar);
        }
    }

}
