package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarNameTest {

    @Test
    void validateNameLongerThenFive() {
        assertThrows(RuntimeException.class, () -> new RacingCarName("5글자넘어요"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateNameIsEmpty(String name) {
        assertThrows(RuntimeException.class, () -> new RacingCarName(name));
    }
}
