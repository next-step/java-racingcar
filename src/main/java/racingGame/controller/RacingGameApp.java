package racingGame.controller;

import racingGame.view.InputView;
import racingGame.domain.RacingGame;
import racingGame.view.ResultView;

public class RacingGameApp {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = InputView.cars();
        int carNumber = carNames.length;

        int roundNumber = 0;
        if (carNumber > 0) {
            System.out.println("시도할 회수는 몇 회 인가요?");
            roundNumber = InputView.rounds();
        }

        RacingGame racingGame = new RacingGame(carNames);

        for(int round = 0; round < roundNumber; round++) {
            ResultView.printResult(racingGame.racing());
        }
        ResultView.printWinner(racingGame.findWinners());
    }
}
