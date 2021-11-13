package racingCar;

import racingCar.ui.ResultView;

import java.util.*;

public class RacingCarGame {
    private int tryTimes;
    private List<Car> raceCar = new ArrayList<>();
    private ResultView resultView = new ResultView();

    RacingCarGame(String[] carNames, int tryTimes) {
        if (tryTimes < 0) {
            throw new IllegalArgumentException("올바른 수를 입력하세요.");
        }
        setRaceCar(carNames);
        this.tryTimes = tryTimes;
    }

    public void playRace() {
        for (int i = 0; i < tryTimes; i++) {
            resultView.printCarRace(raceCar);
        }

        RacingCarGameRule racingCarGameRule = new RacingCarGameRule(raceCar);
        racingCarGameRule.printWinners();
    }

    private void setRaceCar(String[] carNames) {
        for (String name : carNames) {
            raceCar.add(new Car(name));
        }
    }

    public List<Car> getRaceCar() {
        return this.raceCar;
    }

}
