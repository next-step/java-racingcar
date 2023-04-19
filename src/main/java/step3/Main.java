package step3;

import step3.racing.CarRacingGame;
import step3.view.InputView;
import step3.view.ResultView;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        int carsCount = InputView.askInteger("자동차 개수를 입력해주세요.");
        int roundsCount = InputView.askInteger("라운드 수를 입력해주세요.");

        CarRacingGame carRacingGame = new CarRacingGame(carsCount);
        carRacingGame.start(roundsCount);

        ResultView.printGameResult(carRacingGame.result());
    }
}