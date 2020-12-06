package racingcar;

import java.util.Scanner;

public class RacingCarGameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.printQuestions("자동차 대수는 몇 대 인가요?");
        inputView.inputCarCount(new Scanner(System.in));
        inputView.printQuestions("시도할 회수는 몇 회 인가요?");
        inputView.inputMoveCount(new Scanner(System.in));
        System.out.println();

        int carCount = inputView.getCarCount();
        int moveCount = inputView.getMoveCount();

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        ResultView resultView = new ResultView(racingGame);
        resultView.print();

    }

}