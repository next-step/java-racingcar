package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // given
        InputView inputView = new InputView();
        inputView.input();

        RacingGame racingGame = new RacingGame();
        racingGame.setInputValues(inputView.getNumberOfCars(), inputView.getMoveCount());

        // when
        List<int[]> result = racingGame.getResult();
        ResultView resultView = new ResultView();
        resultView.print(result);
    }
}
