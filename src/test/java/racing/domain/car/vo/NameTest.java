package racing.domain.car.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ValueSource(strings = {
            "A", "B", "abc", "jaewo", "스포츠카임"
    })
    @ParameterizedTest
    public void ctorTest(String strName) {
        new Name(strName);
    }

    @ValueSource(strings = {
            "스포츠카임당", "AAAAAAA", "ABCDEFG", "abdwar"
    })
    @ParameterizedTest
    public void ctorInvalidInputExceptionTest(String strName) {
        assertThatThrownBy(() ->
                        new Name(strName))
        .isInstanceOf(InvalidInputException.class);
    }
}
