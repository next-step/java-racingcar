package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void settingMaxLocationCount(RacingCar racingCar) {
        if (racingCar.getForwardCount() > maxLocationCount) {
            maxLocationCount = racingCar.getForwardCount();
        }
    }

    public void settingWinner() {
        winners = racingCars.stream()
                .filter(racingCar -> maxLocationCount == racingCar.getForwardCount())
                .collect(Collectors.toList());
    }

}
