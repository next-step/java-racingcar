package step3.car_racing;

import static step3.car_racing.view.InputView.inputCarNameList;
import static step3.car_racing.view.InputView.inputRacingSize;
import static step3.car_racing.view.ResultView.result;

public class Play {

    public static void main(String[] args) {
        result(inputCarNameList(), inputRacingSize());
    }
}
