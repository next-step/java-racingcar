package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름 객체 관련 테스트")
class CarNameTest {

    @DisplayName("자동차 이름은 5글자까지 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"미니쿠퍼", "레인지로버"})
    void car_create(final String name) {

        final CarName carName = new CarName(name);

        assertThat(carName.getCarName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 빈 값, null 값을 입력하며 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_car_create(final String name) {

        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }

    @DisplayName("스페이스만 입력한 이름도 익셉션 처리한다.")
    @Test
    void error_car_create2() {

        assertThatThrownBy(() -> new CarName("     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수값입니다.");
    }
}
