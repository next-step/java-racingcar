package study.step3;

import java.util.Objects;
import java.util.Optional;

public class RaceManager {

    public static final String NULL_INPUT = "입력값이 null 입니다";
    public static final String LESS_THAN_OR_EQUAL_ZERO = "입력값이 0보다 작거나 같습니다";

    public void register(String carNumber, String roundNumber) {
        validation(carNumber);
        validation(roundNumber);
    }

    private void validation(String number) {
        requireNonNull(number);
        requireGreaterThanZero(requireNumber(number));
    }

    private void requireNonNull(String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
    }

    private int requireNumber(String number) {
        return Optional.of(Integer.parseInt(number))
                .orElseThrow(NumberFormatException::new);
    }

    private void requireGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LESS_THAN_OR_EQUAL_ZERO);
        }
    }
}
