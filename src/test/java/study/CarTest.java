package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 이동성공 테스트")
    @Test
    public void moveCarTest() {
        Car car = new Car("boss");
        car.moveCar(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"eddy", "lily", "boss"})
    public void getCarNameTest(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}
