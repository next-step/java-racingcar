package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainSimulator {

    private static final String SPLIT_LETTER = ",";

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame();
        Cars preRaceCars;
        Cars postRaceCars = new Cars();

        String names = inputView.getCarNames();
        int racingCount = inputView.getRacingCount();

        List<String> carNames = Arrays.stream(names.split(SPLIT_LETTER)).collect(Collectors.toList());
        preRaceCars = racingGame.createCars(carNames);

        resultView.printHeader();

        for (int i = 0; i < racingCount; i++) {
            postRaceCars = racingGame.race(preRaceCars, new RandomMovingStrategy());
            resultView.printCars(postRaceCars);
        }

        Cars winners = racingGame.getWinners(postRaceCars);
        resultView.printWinners(winners);


    }

}
