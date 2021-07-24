package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Name;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ValueSource(strings = {
            "A", "B", "abc", "jaewo", "스포츠카임"
    })
    @ParameterizedTest
    public void valueTest(String strName) {
        new Name(strName).value();
    }

    @ValueSource(strings = {
            "스포츠카임당", "AAAAAAA", "ABCDEFG", "abdwar"
    })
    @ParameterizedTest
    public void valueInvalidInputExceptionTest(String strName) {
        assertThatThrownBy(() ->
                        new Name(strName).value())
        .isInstanceOf(InvalidInputException.class);
    }
}
