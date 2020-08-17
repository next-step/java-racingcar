package racing.core;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class GameRunner {

    public static void main(String[] args) {
        // 입력
        InputView inputView = new InputView();
        int numberOfCars = inputView.howManyCars();
        int numberOfTrials = inputView.howManyTrials();

        // 경주
        RacingGame game = new RacingGame(numberOfCars, numberOfTrials);
        List<TrackInfo> trackInfos = game.run(new RandomMoveStrategy());

        // 결과 출력
        ResultView resultView = new ResultView(trackInfos, numberOfCars);
        resultView.printResult();
    }
}
