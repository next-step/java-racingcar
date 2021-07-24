package racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ValueSource(strings = {
            "A", "B", "abc", "jaewo"
    })
    @ParameterizedTest
    public void valueTest(String strName) {
        new Name(strName).value();
    }

    @ValueSource(strings = {
            "A1", "B2", "a a", "스포츠카", "AAAAAAA", "ABCDEFG", "abdwar"
    })
    @ParameterizedTest
    public void valueInvalidInputExceptionTest(String strName) {
        assertThatThrownBy(() ->
                        new Name(strName).value())
        .isInstanceOf(InvalidInputException.class);
    }
}
