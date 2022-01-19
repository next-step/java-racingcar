package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 참여자는_두_명_이상이다_실패() {

        String[] carNames = "car1".split(",");

        assertThrows(IllegalArgumentException.class, () ->Validator.validatePossibleToStart(carNames));
    }

    @Test
    void 참여자는_두_명_이상이다_성공() {

        String[] carNames = "car1,car2".split(",");

        assertDoesNotThrow(() ->Validator.validatePossibleToStart(carNames));
    }
}