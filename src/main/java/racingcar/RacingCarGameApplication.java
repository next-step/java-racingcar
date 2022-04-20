package racingcar;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String[] carNames = inputView.insertRacingCarName();
        int totalRacingRound = inputView.insertTotalRacingRound();

        RacingGame racingGame =  Arrays.stream(carNames)
                .map(RacingCar::new)
                .collect(collectingAndThen(toList(), RacingGame::new));

        for (int i = 0; i < totalRacingRound; i++) {
            racingGame.roundStart(randomNumberGenerator);
            resultView.roundLogTrace(racingGame.getRacingCars());
        }

        List<String> winners = racingGame.winnersOfTheRace();
        resultView.winnerLogTrace(winners);
    }
}
