package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String[] carNames = inputView.insertRacingCarName();
        int totalRacingRound = inputView.insertTotalRacingRound();

        List<String> carNameList = Arrays.asList(carNames);
        List<RacingCar> racingCars = carNameList.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());

        RacingGame racingGame = new RacingGame(racingCars);

        for (int i = 0; i < totalRacingRound; i++) {
            racingGame.roundStart(randomNumberGenerator.generateRacingRandomNumber());
            resultView.roundLogTrace(racingGame.getRacingCars());
        }

        List<String> winners = racingGame.winnersOfTheRace();
        resultView.winnerLogTrace(winners);
    }
}
