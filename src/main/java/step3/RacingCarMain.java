package step3;

import step3.model.RacingCarGame;
import step3.model.RandomMovingStrategy;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.setNamesAndCount();

        RacingCarGame racingCarGame = new RacingCarGame(inputView.getCarNames());

        playRound(inputView.getRoundCount(), racingCarGame);
    }

    public static void playRound(int roundCount, RacingCarGame racingCarGame) {
        for (int r = 0; r < roundCount; r++) {
            racingCarGame.play(new RandomMovingStrategy());
            ResultView.getRoundResultWithName(racingCarGame.getCars(), "-"); // 결과 보기
        }
        ResultView.printWinner(racingCarGame.getCars());
    }
}
