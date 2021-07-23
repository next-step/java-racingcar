package racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ValueSource(strings = {
            "A", "B", "abc", "jaewon"
    })
    @ParameterizedTest
    public void ctorTest(String strName) {
        new Name(strName);
    }

    @ValueSource(strings = {
            "A1", "B2", "a a", "스포츠카"
    })
    @ParameterizedTest
    public void ctorInvalidInputExceptionTest(String strName) {
        assertThatThrownBy(() ->
                        new Name(strName))
        .isInstanceOf(InvalidInputException.class);
    }
}
