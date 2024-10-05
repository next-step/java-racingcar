package racingGame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"c", "ca", "car", "car1", "car12"})
    @DisplayName("이름이 유효한 값이면 정상적으로 생성된다.")
    void createNameWithValidName(String validName) {
        Name name = new Name(validName);

        assertThat(name).isEqualTo(new Name(validName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"car123", "longname"})
    @DisplayName("이름이 5글자 초과하면 예외가 발생한다.")
    void throwExceptionForLongName(String invalidName) {
        assertThatThrownBy(() -> {
            new Name(invalidName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null 또는 빈문자이면 예외가 발생한다.")
    void throwExceptionForNullNameOrEmpty(String invalidName) {
        assertThatThrownBy(() -> {
            new Name(invalidName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
