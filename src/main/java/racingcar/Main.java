package racingcar;

import java.util.List;

import static racingcar.CarNameValidator.carNameValidation;
import static racingcar.InputView.readCarName;
import static racingcar.InputView.readTryCount;
import static racingcar.RacingSimulator.simulate;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = carNameValidation(readCarName());
        int tryCount = readTryCount();

        simulate(carNames, tryCount);
    }
}
