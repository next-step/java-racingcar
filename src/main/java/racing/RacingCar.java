package racing;

import racing.input.InputView;
import racing.input.RacingInput;

public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingInput input = inputView.racingInput();
    }
}
