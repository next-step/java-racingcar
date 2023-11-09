package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("4 이상의 숫자를 받는다면 앞으로 전진한다.")
    void carGoTest(int condition) {
        Car car = new Car("tester1");
        assertThat(car.getCurrentStatus()).isEqualTo(0);

        car.go(condition);
        assertThat(car.getCurrentStatus()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("4보다 작은 숫자를 받는다면 앞으로 전진한다.")
    void carDoNotGoTest(int condition) {
        Car car = new Car("tester1");
        assertThat(car.getCurrentStatus()).isEqualTo(0);

        car.go(condition);
        assertThat(car.getCurrentStatus()).isEqualTo(0);
    }
}
