package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Name;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {
    private Name name;

    @Test
    void valid_null_또는_빈값() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            name = new Name("");
            name = new Name(null);
        }).withMessageMatching("입력값이 없습니다.");
    }

    @Test
    void valid_5자_초과() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            name = new Name("dddddd");
        }).withMessageMatching("자동차의 이름은 5자를 초과할 수 없다.");
    }

}
