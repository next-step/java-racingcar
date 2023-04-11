package racingcar;

import racingcar.service.RacingCar;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<Integer> inputValues = inputView.input();
        for(int i=0; i<inputValues.get(0); i++) {
            RacingCar racingCar = new RacingCar(String.valueOf(i));
        }

    }
}
