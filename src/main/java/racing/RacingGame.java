package racing;


import racing.strategy.MoveStrategy;
import racing.strategy.RacingMoveStategy;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private RacingCars racingCars;
    private int countOfRacing;


    public RacingGame(int countOfRacing) {
        this.countOfRacing = countOfRacing;
    }

    public int getCountOfRacing() {
        return this.countOfRacing;
    }



    public static void main(String[] args) {
        String[] nameOfRacingCarList = InputView.getRacingCarInputWithName();
        int countOfRacing = InputView.getRacingInput();
        MoveStrategy moveStrategy = new RacingMoveStategy();
        RacingGame racingGame = new RacingGame(countOfRacing);

        racingGame.start(nameOfRacingCarList, moveStrategy);

        ResultView.viewRacingResult(racingGame);
    }

    public void start(String[] nameOfRacingCarList, MoveStrategy moveStrategy) {
        this.racingCars = RacingCars.of(nameOfRacingCarList);
        racingCars.startRacing(this.countOfRacing, moveStrategy);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
