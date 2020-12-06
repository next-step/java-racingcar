package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

public class RacingGameTest {

    @Test
    @DisplayName("초간단 자동차 경주 게임 테스트")
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
    @DisplayName("자동차 경주(우승자) 게임 테스트")
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

    @Test
    @DisplayName("자동차의 이름과 위치를 가지고 우승자를 판별하는 기능 테스트")
    void pickWinner() {

        InputView inputView = new InputView();
        inputView.printQuestions("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputView.inputCarNames(new Scanner("pobi,crong,honux"));
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        inputView.inputMoveCount(new Scanner("5"));
        System.out.println();

        List<CarName> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        RacingGame racingGame = new RacingGame(carNames, moveCount);
        List<RacingCar> winners = racingGame.pickWinner();
        ResultView resultView = new ResultView(racingGame);
        resultView.print();

        winners.forEach(car ->
                System.out.printf("name : %s, advanced : %d%n",
                        car.getCarName().getName(),
                        car.getAdvancedCount())
        );

    }
}
