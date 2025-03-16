package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveIntegerTest {

    @DisplayName("음의 정수 객체 생성 시 예외 발생")
    @Test
    void constructor() {
        Assertions.assertThatThrownBy(() -> new PositiveInteger(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0 객체 생성 시 value가 0인지 확인")
    @Test
    void constructor_2() {
        int value = 0;
        PositiveInteger positiveInteger = new PositiveInteger(value);
        Assertions.assertThat(positiveInteger.value()).isEqualTo(value);
    }

    @DisplayName("addOne 메서드 호출 시 value가 1 증가")
    @Test
    void addOne() {
        int initialValue = 0;
        PositiveInteger positiveInteger = new PositiveInteger(0);
        positiveInteger.addOne();
        Assertions.assertThat(positiveInteger.value()).isEqualTo(++initialValue);
    }

}
