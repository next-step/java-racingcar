package racingcar;

import racingcar.view.InputView;

public class RacingCarApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int racingCarNumbers = inputView.getRacingCarNumbers();
        int racingRound = inputView.getRacingRound();

    }
}
