package racing;

import racing.view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.getCarCount();
        int moveCount = inputView.getMoveCount();
    }
}
