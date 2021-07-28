import racingcar.domain.MovableStrategy;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.receiveCarCount();
        int roundCount = InputView.receiveRoundCount();

        RacingGame racingGame = new RacingGame(carCount, roundCount);
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        while (!racingGame.isEnd()) {
            racingGame.race(movableStrategy);
            ResultView.print(racingGame.getCars());
        }
    }
}
