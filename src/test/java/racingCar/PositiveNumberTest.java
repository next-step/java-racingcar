package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {
    @DisplayName("문자열 매개변로 인스턴스 생성")
    @Test
    void createInstanceWithStringParameter() {
        PositiveNumber positiveNumber = new PositiveNumber("123");
        assertThat(positiveNumber.getValue()).isEqualTo(123);
    }

    @DisplayName("음수 매개변로 인스턴스 생성 시 throw RuntimeException")
    @Test
    void createInstanceWithNegativeParameter() {
        assertThatThrownBy(() -> {
            new PositiveNumber("-1");
        }).isInstanceOf(RuntimeException.class).hasMessage("Negative number is not allowed");
    }
}
