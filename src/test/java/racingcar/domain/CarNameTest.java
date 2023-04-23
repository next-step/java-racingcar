package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "hyundai")
    void NULL또는빈값(String name) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 1자 이상이어야 하며, 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차이름조회")
    void 자동차이름조회() {
        CarName carName = new CarName("bmw");

        Assertions.assertThat(carName.getName()).isEqualTo("bmw");
    }
}
