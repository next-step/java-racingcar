package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.DrivingStrategy;
import racingcar.domain.Round;
import racingcar.domain.dto.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameConsole {

    private final InputView inputView;
    private final OutputView outputView;
    private final DrivingStrategy drivingStrategy;

    public RacingGameConsole(
        InputView inputView, OutputView outputView, DrivingStrategy drivingStrategy
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.drivingStrategy = drivingStrategy;
    }

    public void start() {
        List<String> carNames = inputView.inputCarNames();
        int round = inputView.inputRound();

        Cars cars = Cars.from(carNames);
        play(cars, round);

        outputView.printWinners(cars.winners());
    }

    public void play(Cars cars, int roundAmount) {
        outputView.printRoundResultHeader();
        Round round = Round.of(roundAmount);
        while (!round.isEnd()) {
            round.progress();
            play(cars);
        }
    }

    private void play(Cars cars) {
        cars.drive(drivingStrategy);
        RoundResult roundResult = cars.result();
        outputView.printRoundResult(roundResult);
    }
}
