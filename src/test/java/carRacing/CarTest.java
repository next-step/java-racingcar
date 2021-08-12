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
        car.go(() -> true);
        assertThat(car.isEqualPosition(new Position(1))).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차가 전략에 따라 멈추는지 테스트")
    void stop() {
        car.go(() -> false);
        assertThat(car.isEqualPosition(new Position(0))).isEqualTo(true);
    }
}