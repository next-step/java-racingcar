package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("자동차 이름의 길이가 유효한지 테스트")
    void setCar() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("abcdef"));
    }

    @Test
    @DisplayName("자동차가 전략에 따라 움직이는지 테스트")
    void go() {
        assertThat(car.go(() -> true)).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 전략에 따라 멈추는지 테스트")
    void stop() {
        assertThat(car.go(() -> false)).isEqualTo(0);
    }
}