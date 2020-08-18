package racing;


import racing.strategy.MoveStrategy;
import racing.strategy.RacingMoveStategy;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private MoveStrategy moveStrategy;

    public static void main(String[] args) {
        int countOfRacingCar = InputView.getRacingCarInput();
        int countOfRacing = InputView.getRacingInput();

        MoveStrategy moveStategy = new RacingMoveStategy();
        RacingGame racingGame = new RacingGame(moveStategy);
        List<RacingCar> racingCarList = racingGame.setRacing(countOfRacing);
        List<RacingCar> racingResult = racingGame.startRacing(countOfRacing, racingCarList);
        System.out.println(racingResult);
        ResultView.viewRacingResult(racingResult);
    }
    public RacingGame() {}

    public RacingGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<RacingCar> setRacing(int countOfRacingCar) {
       return Stream.generate(() -> new RacingCar(moveStrategy)).limit(countOfRacingCar).collect(Collectors.toList());
    }

    public List<RacingCar> startRacing(int countOfRacingCar, List<RacingCar> racingCarList) {
        racingCarList.forEach(racingCar -> racingCar.startRacing(countOfRacingCar));
        return racingCarList;
    }
}
