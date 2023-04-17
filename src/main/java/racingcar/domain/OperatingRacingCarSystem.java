package racingcar.domain;

import java.util.function.Predicate;

public class OperatingRacingCarSystem {
    public boolean decideSystemExitByLengthCheck(String carName) {

        Predicate<String> checkLength = (text) -> text.length() > 5;

        return checkLength.test(carName);
    }
}
