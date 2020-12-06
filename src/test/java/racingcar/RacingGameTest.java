package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

public class RacingGameTest {

    @Test
    void startStep3() {

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

    @Test
    void startStep4() {

        InputView inputView = new InputView();
        inputView.printQuestions("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputView.inputCarNames(new Scanner("pobi,crong,honux"));
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        inputView.inputMoveCount(new Scanner("5"));
        System.out.println();

        List<CarName> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        RacingGame racingGame = new RacingGame(carNames, moveCount);
        ResultView resultView = new ResultView(racingGame);
        resultView.print();

    }



}
