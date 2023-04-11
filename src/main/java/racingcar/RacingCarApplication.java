package racingcar;

import racingcar.view.InputView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Integer> inputValues = inputView.input();
    }
}
