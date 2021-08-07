package edu.nextstep.racingcarwinner;

import edu.nextstep.racingcarwinner.domain.Car;
import edu.nextstep.racingcarwinner.domain.RacingGame;
import edu.nextstep.racingcarwinner.view.InputView;
import edu.nextstep.racingcarwinner.view.OutputView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carName = inputView.inputCarName();
        int roundNum = inputView.inputRoundNum();

        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.makeCarList(carName);
        racingGame.joinGame(carList);

        outputView.printStartSign();
        for (int i = 0; i < roundNum; i++) {
            racingGame.playOneRound();
            outputView.printOneRound(racingGame);
        }

        List<Car> winners = racingGame.getWinner();
        outputView.printWinner(winners);

    }
}
