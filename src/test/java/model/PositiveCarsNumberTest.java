package model;

import exception.NegativeCarsNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositiveCarsNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -3, -5, -8})
    void 자동차_댓수가_음수와_0의_값이_나오면_Exception_발생(int carsNumber) {
        assertThrows(NegativeCarsNumberException.class, () -> new PositiveCarsNumber(carsNumber));
    }
}
