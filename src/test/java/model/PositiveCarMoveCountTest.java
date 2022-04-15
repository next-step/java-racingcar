package model;

import exception.NegativeCarMoveCountException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositiveCarMoveCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -4, -7})
    void 자동차_이동_횟수가_음수와_0의_값이_나오면_Exception_발생(int countNumber) {
        assertThrows(NegativeCarMoveCountException.class, () -> new PositiveCarMoveCount(countNumber));
    }

}
