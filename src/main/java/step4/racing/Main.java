package step4.racing;

import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        String carNames = InputView.getParticipatedCarNames();
        int tryCount = InputView.getTryCount();
        int maxRandomNumber = InputView.getMaxRandomNumber();

        RacingGame game = new RacingGame(carNames, maxRandomNumber);
        ResultView resultView = new ResultView(game.cars());
        System.out.println("실행 결과\n");
        for (int i = 0; i < tryCount; i++) {
            game.rollTheDice();
            resultView.broadcast();
            System.out.println();
        }
        System.out.println();
        resultView.printWinner(game.winners());
    }
}
