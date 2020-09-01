package racing.core;

import racing.core.dto.Trial;
import racing.core.patterns.RandomMoveStrategy;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class GameRunner {

    public static void main(String[] args) {
        // 입력
        InputView inputView = new InputView();
        String[] namesOfCars = inputView.getNamesOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        // 경주
        RacingGame game = new RacingGame(namesOfCars, numberOfTrials);
        List<Trial> trials = game.run(new RandomMoveStrategy());

        // 결과 출력
        ResultView resultView = new ResultView(trials, game.getWinners());
        resultView.printResult();
    }
}
