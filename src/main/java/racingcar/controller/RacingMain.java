package racingcar.controller;

import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.factory.CarFactory;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.ui.RacingInputView;
import racingcar.ui.RacingResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new Cars(new CarFactory().generate(new CarName(RacingInputView.carsName()).carNameList())), RacingInputView.raceTimes());
        while (!racingGame.isEndGame()) {
            RacingResultView.printResult(racingGame.start(new RandomMoveStrategy()));
        }
        RacingResultView.printRacingWinner(racingGame.cars());
    }
}
