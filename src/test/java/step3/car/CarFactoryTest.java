package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarFactoryTest {

    @Test
    @DisplayName("자동차 이동 시도 회수가 0보다 작으면 예외 발생")
    public void numberOfCarsExceptionTest() {

        // given
        int numberOfCars = -1;

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> CarFactory.of(numberOfCars)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("입력값에 맞는 자동차 대수가 생성 되어야 한다.")
    public void createCarTest(int numberOfCar) {

        // given
        CarFactory carFactory = CarFactory.of(numberOfCar);

        // when
        List<Car> cars = carFactory.createCars();

        // then
        assertThat(cars.size()).isEqualTo(numberOfCar);
    }
}
