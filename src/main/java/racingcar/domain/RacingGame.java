package racingcar.domain;

import java.util.List;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;
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
            OutputView.showResult(cars.cars());
        }
        cars.findWinners();
        List<Car> winners = cars.getWinners();
        OutputView.showWinners(winners);
    }

    private void setUpGame() {
        String carNames = InputView.getCarNames();
        String[] splitCarNames = StringUtils.splitCarNames(carNames);
        cars = new Cars(splitCarNames, new RandomEngine());
        String inputRound = InputView.getRound();
        round = new Round(inputRound);
    }
}
