package racingcar.application;

import racingcar.application.request.InputView;
import racingcar.application.response.*;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {
    private static final int GAME_DIFFICULTY = 4;
    private static final String NAME_SEPARATOR = ",";

    public ResultView race(final InputView view) {
        final RacingGame racingGame = new RacingGame(GAME_DIFFICULTY, view.getInputName().split(NAME_SEPARATOR));
        final RacingViews racingViews = new RacingViews(
                IntStream.rangeClosed(1, view.getTime())
                        .mapToObj(time -> raceOnce(time, racingGame))
                        .collect(Collectors.toList())
        );
        final WinnerViews winnerViews = bindWinnerViews(racingGame.whoIsTheWinner());
        return new ResultView(racingViews, winnerViews);
    }

    private RacingView raceOnce(final int time, final RacingGame racingGame) {
        return new RacingView(time, racingGame.race());
    }

    private WinnerViews bindWinnerViews(final RacingCars winners) {
        return new WinnerViews(
                winners.get()
                        .stream()
                        .map(RacingCar::getName)
                        .collect(Collectors.toList())
        );
    }
}
