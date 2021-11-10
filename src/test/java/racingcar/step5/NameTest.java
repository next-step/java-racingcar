package racingcar.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step5.domain.Name;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void createName() {
        Name name = new Name("k3");
        assertThat(name).isEqualTo(new Name("k3"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"avante", "", " "})
    @DisplayName("자동차 이름이 5자를 초과 or 빈값 검증")
    void naming1(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new Name("k3"))
                .doesNotThrowAnyException();
    }

}
