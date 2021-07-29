package step3;

import step3.view.input.InputDTO;
import step3.view.input.InputView;

/**
 * 통합 테스트를 위한 클래스.
 */
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDTO inputDTO = inputView.receiveInput();
        int tryCount = inputDTO.getTryCount();
        int carCount = inputDTO.getCarCount();

        RacingGame racingGame = new RacingGame(tryCount, carCount);
        racingGame.start();
    }
}
