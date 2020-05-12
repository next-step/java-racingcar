package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ResultView;

public class RacingGameLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        int numberOfCar = inputView.requestNumberOfCar();
        int time = inputView.requestTime();

        RacingGame racingGame = RacingGameFactory.newRacingGame(numberOfCar);

        outputView.print(createResultViews(racingGame, time));
    }

    private List<ResultView> createResultViews(RacingGame racingGame, int time) {
        return IntStream.range(0, time)
            .mapToObj(value -> {
                racingGame.tryMove();
                return new ResultView(racingGame.getPositions());
            }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new RacingGameLauncher().play();
    }
}
