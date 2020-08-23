package racingcar;


import static racingcar.domain.RacingGame.racingStart;
import static racingcar.view.InputView.getInputCarsName;
import static racingcar.view.InputView.getInputTryCount;

public class RacingCarMain {
    public static void main(String[] args) {
        String carsName = getInputCarsName();
        int tryCount = getInputTryCount();

        racingStart(carsName, tryCount);
    }
}
