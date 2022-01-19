package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 참여자는_두_명_이상이다_실패() {
        String[] carNames = "car1".split(",");

        assertThrows(IllegalArgumentException.class,
            () -> Validator.validatePossibleToStart(carNames));
    }

    @Test
    void 참여자는_두_명_이상이다_성공() {
        String[] carNames = "car1,car2".split(",");

        assertDoesNotThrow(() -> Validator.validatePossibleToStart(carNames));
    }

    @Test
    void 자동차의_이름_글자수_5자_이하_실패() {
        String carName = "carcar1";

        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameLength(carName));
    }

    @Test
    void 자동차의_이름_글자수_5자_이하_성공() {
        String carName = "car1";

        assertDoesNotThrow(() -> Validator.validateNameLength(carName));
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_실패() {
        String trial = "a";

        assertThrows(IllegalArgumentException.class, () -> Validator.isNumber(trial));
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_성공() {
        String trial = "5";

        assertDoesNotThrow(() -> Validator.isNumber(trial));
    }
}