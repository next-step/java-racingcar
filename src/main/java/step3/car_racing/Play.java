package step3.car_racing;

import static step3.car_racing.view.InputView.inputCarSize;
import static step3.car_racing.view.InputView.inputRacingSize;
import static step3.car_racing.view.ResultView.result;

public class Play {

    public static void main(String[] args) {
        result(inputCarSize(), inputRacingSize());
    }
}
