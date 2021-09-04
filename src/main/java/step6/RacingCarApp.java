package step6;

import step6.view.InputView;

public class RacingCarApp {
    public static void main(String[] args) {
        String carNames = InputView.requireCarName();
        System.out.println(carNames);
    }
}
