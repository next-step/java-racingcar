package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.car.RandomEngine;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.utils.StringUtils;

public class RacingGame {

    private Cars cars;
    private Round round;

    public RacingGame() {
    }

    public void run() {
        setUpGame();
        while (round.untilEnd()) {
            cars.moveAll();
            List<ResultDto> currentResults = getCurrentResult();
            OutputView.showResult(currentResults);
        }
        Winners winners = Winners.findWinners(cars.cars());
        List<ResultDto> winnersDto = getWinners(winners);
        OutputView.showWinners(winnersDto);
    }

    private List<ResultDto> getWinners(Winners winners) {
        return winners.winners()
            .stream()
            .map(ResultDto::new)
            .collect(Collectors.toList());
    }

    private List<ResultDto> getCurrentResult() {
        return cars.cars()
            .stream()
            .map(ResultDto::new)
            .collect(Collectors.toList());
    }

    private void setUpGame() {
        String carNames = InputView.getCarNames();
        String[] splitCarNames = StringUtils.splitCarNames(carNames);
        cars = new Cars(splitCarNames, new RandomEngine());
        String inputRound = InputView.getRound();
        round = new Round(inputRound);
    }
}
