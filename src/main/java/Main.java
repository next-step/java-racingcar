import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.receiveCarNames();
        int roundCount = InputView.receiveRoundCount();

        Cars cars = new Cars(CarFactory.makeCars(carNames));
        RacingGame racingGame = new RacingGame(new RoundCount(roundCount), new RandomMovableStrategy());
        RaceResult raceResult = racingGame.race(cars);
        ResultView.print(raceResult);
    }
}
