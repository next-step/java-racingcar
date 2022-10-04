package step3;

import step3.domain.Play;
import step3.view.InputView;

public class RacingCarApplication {

    private static final InputView INPUT_VIEW = new InputView();
    private static final Play PLAY = new Play();

    public static void main(String[] args) {
        int numberOfCar = INPUT_VIEW.numberOfCar();
        int count = INPUT_VIEW.count();

        PLAY.playGame(numberOfCar, count);
    }
}
