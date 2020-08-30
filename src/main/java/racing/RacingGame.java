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
    private RacingCarList racingCarList;
    private String[] nameOfRacingCarList;
    private int countOfRacing;

    public RacingGame() {}
    public RacingGame(MoveStrategy moveStrategy, String[] nameOfRacingCarList, int countOfRacing) {
        this.moveStrategy = moveStrategy;
        this.nameOfRacingCarList = nameOfRacingCarList;
        this.countOfRacing = countOfRacing;
    }

    public RacingGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public static void main(String[] args) {
        String[] nameOfRacingCarList = InputView.getRacingCarInputWithName();
        int countOfRacing = InputView.getRacingInput();
        MoveStrategy moveStrategy = new RacingMoveStategy();
        RacingGame racingGame = new RacingGame(moveStrategy, nameOfRacingCarList, countOfRacing);

        racingGame.start();

        ResultView.viewRacingResult(racingGame.getRacingCarList());
    }

    private void start() {
        this.racingCarList = new RacingCarList(nameOfRacingCarList, moveStrategy);
        racingCarList.startRacing(countOfRacing);
    }

    private RacingCarList getRacingCarList() {
        return racingCarList;
    }


    public List<RacingCar> setRacing(int countOfRacingCar) {
       return Stream.generate(() -> new RacingCar(moveStrategy)).limit(countOfRacingCar)
                                                                .collect(Collectors.toList());
    }


    public List<RacingCar> startRacing(int countOfRacingCar, List<RacingCar> racingCarList) {
        racingCarList.forEach(racingCar -> racingCar.startRacing(countOfRacingCar));
        return racingCarList;
    }

}
