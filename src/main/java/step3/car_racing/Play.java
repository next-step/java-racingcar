package step3.car_racing;

import step3.car_racing.view.InputView;
import step3.car_racing.view.ResultView;

public class Play {

    public static void main(String[] args) {
        InputView input = new InputView();

        new ResultView().result(input);
    }
}
