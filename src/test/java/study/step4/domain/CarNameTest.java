package study.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @DisplayName("자동차 이름은 5자 이하이다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    void carName(String name) {
        CarName carName = new CarName(name);

        assertThat(carName).isEqualTo(new CarName(name));
    }

    @DisplayName("자동차 이름은 5자 초과시 exception 이 발생한다")
    @Test
    void carNameException() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("abcdef");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없다");
    }
}