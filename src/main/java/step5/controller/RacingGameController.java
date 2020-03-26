package step5.controller;

import java.util.Scanner;

import step5.domain.RacingGame;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = scanner.nextInt();

        InputView inputView = new InputView(carNames, moveCount);
        RacingGame racingGame = new RacingGame(inputView.getMoveCount(), inputView.getCars());
        racingGame.racingByRepeatCount();

        ResultView resultView = new ResultView(racingGame.getWinnerNames(), racingGame.getMoveCars());
        System.out.println(resultView.printMoveProcess());
        System.out.println(resultView.resultWinnerUser());

    }
}
