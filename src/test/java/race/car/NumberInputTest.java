package race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

public class NumberInputTest {


    @Test
    @DisplayName("Null  체크")
    void isNullTest() {
        assertThrows(NullPointerException.class, () -> {
            NumberInput.valueCheck(null);
        });
    }


    @Test
    @DisplayName("EMPTY  체크")
    void isEmptyTest() {
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.valueCheck("");
        });
    }

    @Test
    @DisplayName("숫자인지 체크")
    void isNumberTest() {
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.valueCheck("dsaf");
        });
    }

    @Test
    @DisplayName("0을입력했는지 체크")
    void isZeroTest() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            NumberInput.valueCheck("0");
        });
    }
}
