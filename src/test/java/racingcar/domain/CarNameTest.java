package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("5자 길이의 자동차 이름을 생성한다.")
    void valueOf_ShouldReturnCarNameObject() {
        CarName actual = CarName.valueOf("abcde");

        assertThat(actual).isEqualTo(new CarName("abcde"));
    }

    @Test
    @DisplayName("5자 길이의 자동차 이름을 생성한다.")
    void valueOf_ShouldFailWhenANameOfNamesOver5() {
        assertThatThrownBy(() -> CarName.valueOf("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
