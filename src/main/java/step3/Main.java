package step3;

import step3.view.input.Input;
import step3.view.input.InputView;

/**
 * 통합 테스트를 위한 클래스.
 */
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Input input = inputView.receiveInput();
        int tryCount = input.getTryCount();
        int carCount = input.getCarCount();

        RacingGame racingGame = new RacingGame(tryCount, carCount);
        racingGame.race(tryCount);
    }
}
