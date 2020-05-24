package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("CarName은 유효한 String을 가진다.")
    @ParameterizedTest
    @ValueSource(strings = "java, python, go, c++, perl, ruby, php")
    public void verify_validString_shouldSucceed(String name) {
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("입력 값이 null 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullSource
    public void verify_nullString_shouldFail(String name) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 empty 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = "     ")
    public void verify_emptyString_shouldFail(String name) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
