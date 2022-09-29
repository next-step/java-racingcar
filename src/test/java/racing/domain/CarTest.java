package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 검증 - 출발지 확인")
    void 차량_기본_출발지_확인() {
        assertThat(new Car("car").getForwardCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 검증 - 차량명 유효성 확인")
    void 차량명_길이_확인() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
