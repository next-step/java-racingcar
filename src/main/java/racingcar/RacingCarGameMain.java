package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.printQuestions("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputView.inputCarNames(new Scanner(System.in));
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        inputView.inputMoveCount(new Scanner(System.in));
        System.out.println();

        List<CarName> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        RacingGame racingGame = new RacingGame(carNames, moveCount);
        racingGame.pickWinner();
        ResultView resultView = new ResultView(racingGame);
        resultView.print();

    }

}