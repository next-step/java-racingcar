import racingcar.domain.RacingGame;
import racingcar.domain.RandomMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.receiveCarCount();
        int roundCount = InputView.receiveRoundCount();

        RacingGame racingGame = new RacingGame(carCount, roundCount, new RandomMovableStrategy());
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.print(racingGame.getCars());
        }
    }
}
