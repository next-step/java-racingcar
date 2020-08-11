package racingcar;


import static racingcar.racing.Racing.racingStart;
import static racingcar.view.InputView.getInputCarsName;
import static racingcar.view.InputView.getInputTryCount;

public class RacingCarMain {
    public static void main(String[] args) {
        String carsName = getInputCarsName();
        int tryCount = getInputTryCount();

        racingStart(carsName, tryCount);
    }
}
