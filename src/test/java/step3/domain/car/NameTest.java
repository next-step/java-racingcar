package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    private static final String NameTooLong = "aaaaaa";

    @DisplayName("이름의 길이가 1이상 5이하가 아니라면 Name 생성시 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] name: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {NameTooLong})
    void createName(String inputName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(inputName))
                .withMessage(Name.NAME_LENGTH_ERROR_MESSAGE);
    }

}
