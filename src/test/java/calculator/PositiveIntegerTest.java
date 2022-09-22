package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositiveIntegerTest {

    @DisplayName("음수를 전달하는 경우, 예외가 발생해야 한다.")
    @Test
    void createInstance_givenNegative() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PositiveInteger(-1))
                .withMessage("음수를 전달할 수 없습니다.");
    }

    @DisplayName("같은 숫자를 전달하는 경우, 객체는 서로 같아야 한다.")
    @Test
    void equalsAndHashCode() {
        assertThat(new PositiveInteger(1)).isEqualTo(new PositiveInteger(1));
    }

    @DisplayName("숫자를 나타내는 문자열를 전달하는 경우, 해당 값을 가진 객체가 생성되어야 한다.")
    @Test
    void from() {
        assertThat(PositiveInteger.from("1")).isEqualTo(new PositiveInteger(1));
    }

    @DisplayName("숫자를 나타내지 않는 문자열을 전달하는 경우, 예외가 발생해야 한다.")
    @Test
    void from_givenNotNumber() {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> PositiveInteger.from("a"));
    }

    @DisplayName("두 숫자를 더하면 더한 값을 반환해야 한다.")
    @Test
    void plus() {
        int num1 = 1;
        int num2 = 2;
        PositiveInteger actual = new PositiveInteger(num1).plus(new PositiveInteger(num2));
        assertThat(actual).isEqualTo(new PositiveInteger(num1 + num2));
    }

}
