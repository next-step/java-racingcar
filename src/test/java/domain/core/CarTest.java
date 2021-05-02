package domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("0-9 랜덤생성해서 나온 숫자 기반으로 전진할지 멈출지")
    void go_or_stop() {
        // given
        Car car = new Car("");

        // when
        car.play();

        // then
        assertThat(car.getGoString()).contains("", "-");
    }
}
