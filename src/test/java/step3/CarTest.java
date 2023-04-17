package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void negative_carNumber() {
        assertThatThrownBy(() -> new Car(-5)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("차 번호가 자연수가 아닙니다.");
    }
}
