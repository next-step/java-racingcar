package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름이 null,빈값, 빈공백 일 경우 오류가 발생합니다.")
    void test01() {
        assertAll(
                () -> assertThatThrownBy(() -> new CarName(null)),
                () -> assertThatThrownBy(() -> new CarName("")),
                () -> assertThatThrownBy(() -> new CarName(" "))
        );
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 경우 오류가 발생합니다.")
    void test02() {
        assertThatThrownBy(() -> new CarName("123456"));
    }

    @Test
    @DisplayName("자동차 이름이 정상적으로 생성됩니다.")
    void test03() {
        String expected = "12345";
        String actual = new CarName(expected).getName();
        assertThat(actual).isEqualTo(expected);
    }

}