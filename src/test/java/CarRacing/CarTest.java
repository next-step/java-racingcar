package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("tony");
    }

    @DisplayName("자동차 객체 생성 성공")
    @Test
    void makeCar() {
        assertThat(car).isNotNull();
        assertThat(car.getStatusLine()).isZero();
    }

    @DisplayName("자동차 이동")
    @Test
    void moveCar(){
        car.move(4);

        assertThat(car.getStatusLine()).isEqualTo(1);
    }
}
