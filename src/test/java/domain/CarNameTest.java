package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름 생성 - 정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"차", "자동차이름"})
    void createCarNameTest(String name) {
        CarName carName = new CarName(name);
        assertThat(carName).isEqualTo(new CarName(name));
    }

    @DisplayName("자동차 이름 생성 - 실패 케이스")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"새로운자동차", "123456"})
    void createTest(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}