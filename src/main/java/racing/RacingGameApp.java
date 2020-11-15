package racing;

import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameApp {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputNameOfCars(), InputView.inputNumberOfRound());
        System.out.println("실행 결과");

        racingGame.run()
                .forEach(msg -> System.out.println(msg));

        ResultView.printVictoryCarNames(racingGame.getCars());
    }
}
