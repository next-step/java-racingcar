package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Name;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과"})
    @DisplayName("Name 생성 실패")
    public void failed(String string) {
        assertThatThrownBy(() -> new Name(string)).isInstanceOf(IllegalArgumentException.class);
    }
}
