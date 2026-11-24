package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomMoveStrategy;
import racingcar.dto.RacingGameDto;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame(
                InputView.readCarNames(),
                InputView.readAttemptCount()
        );

        RandomMoveStrategy strategy = new RandomMoveStrategy(new RandomGenerator());

        OutputView.printResultMessage();

        while (!racingGame.isFinished()) {
            Cars result = racingGame.playRound(strategy);
            OutputView.printRoundResult(RacingGameDto.from(result));
        }

        List<String> winnerNames = getWinnerNames(racingGame);
        OutputView.printWinners(winnerNames);
    }

    private static List<String> getWinnerNames(RacingGame racingGame) {
        return racingGame.findWinners().stream()
                .map(car -> car.getName().getValue())
                .toList();
    }
}