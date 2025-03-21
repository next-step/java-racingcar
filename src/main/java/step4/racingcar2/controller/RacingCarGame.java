package step4.racingcar2.controller;

import java.util.ArrayList;
import java.util.List;
import step4.racingcar2.model.RacingCar;
import step4.racingcar2.model.RacingCarEngine;
import step4.racingcar2.model.RacingCarGameRound;
import step4.racingcar2.model.RacingCarName;
import step4.racingcar2.ui.InputView;
import step4.racingcar2.ui.ResultView;

public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ArrayList<String> carNames = inputView.getCarNames();
        int numberOfRounds = inputView.getNumberOfRounds();

        List<RacingCar> cars = initCars(carNames);
        List<RacingCarGameRound> gameRounds = initRounds(numberOfRounds, cars);

        System.out.println();
        System.out.println("실행 결과");

        ResultView resultView = new ResultView();
        for (RacingCarGameRound gameRound : gameRounds) {
            gameRound.start();
            resultView.showRoundResult(gameRound);
        }

        RacingCarGameRound lastGameRound = gameRounds.get(numberOfRounds - 1);
        resultView.showRoundWinners(lastGameRound);
    }

    static List<RacingCar> initCars(ArrayList<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(new RacingCarName(carName), new RacingCarEngine()));
        }
        return cars;
    }

    static List<RacingCarGameRound> initRounds(int numberOfRounds, List<RacingCar> cars) {
        List<RacingCarGameRound> gameRounds = new ArrayList<>();
        for (int i = 0; i < numberOfRounds; i++) {
            gameRounds.add(new RacingCarGameRound(cars));
        }
        return gameRounds;
    }

}
