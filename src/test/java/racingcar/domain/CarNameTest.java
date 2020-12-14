package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름이 5글자가 넘을 경우 테스트")
    void valid() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName("aaaaaa"));
    }

    @Test
    void create() {
        assertThat(new CarName("ruby")).isEqualTo(new CarName("ruby"));
    }

}
