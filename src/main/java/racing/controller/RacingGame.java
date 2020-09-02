package racing.controller;


import racing.domain.RacingCars;
import racing.strategy.MoveStrategy;
import racing.strategy.RacingMoveStategy;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

    private RacingCars racingCars;
    private int countOfRacing;


    public RacingGame(int countOfRacing) {
        this.countOfRacing = countOfRacing;
    }

    public int getCountOfRacing() {
        return this.countOfRacing;
    }

    public void start(String[] nameOfRacingCarList, MoveStrategy moveStrategy) {
        this.racingCars = RacingCars.of(nameOfRacingCarList);
        racingCars.startRacing(this.countOfRacing, moveStrategy);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
