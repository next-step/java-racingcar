package race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberInputTest {

    /*
    *
    * NumberInput.valueCheck를 사용해서 null, empty 등의 에러처리를했는데 왜 오류가 발생이될까요?
    *
    @ParameterizedTest
    @NullSource
    @DisplayName("Null  체크")
    void nullTest(String paramText) {
        assertTrue(NumberInput.valueCheck(paramText));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("empty  체크")
    void emptyTest(String paramText) {
        assertTrue(NumberInput.valueCheck(paramText));
    }
    */
}
