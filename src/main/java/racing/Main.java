package racing;

import racing.domain.CarRacingGame;
import racing.view.InputView;
import racing.view.ResultView;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        String carNames = InputView.askString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int roundsCount = InputView.askInteger("라운드 수를 입력해주세요.");

        CarRacingGame carRacingGame = new CarRacingGame(carNames);

        ResultView.printGameStart();
        for (int i = 0; i < roundsCount; i++) {
            carRacingGame.doRound();
            ResultView.printCars(carRacingGame.result());
        }
        ResultView.printWinners(carRacingGame.winners());
    }
}