package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class RacingGameTest {

    @Test
    void start() {

        InputView inputView = new InputView();
        inputView.printQuestions("자동차 대수는 몇 대 인가요?");
        inputView.inputCarCount(new Scanner("3"));
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        inputView.inputMoveCount(new Scanner("5"));
        System.out.println();

        int carCount = inputView.getCarCount();
        int moveCount = inputView.getMoveCount();

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        ResultView resultView = new ResultView(racingGame);
        resultView.print();

    }

}
