package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차(Car) 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of("1");
    }

    @DisplayName("자동차 인덱스(CarIndex)로 자동차를 만들 수 있다.")
    @Test
    void create() {
        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("이동 규칙(Moveable)에 따라 움직이거나 멈춰 있을 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "true,0,1",
            "false,0,0"
    })
    void move(boolean isMove, int location, int expected) {
        // when
        String name = "2";
        Car car = Car.of(name, location);
        Moveable moveable = () -> isMove;
        Car forward = car.forward(moveable);

        // then
        assertThat(forward).isEqualTo(Car.of(name, expected));
    }

    @DisplayName("자동차 보고서(CarReport)를 만들 수 있다.")
    @Test
    void report() {
        // when
        CarReport carReport = car.report();

        // then
        assertThat(carReport).isNotNull();
    }
}
