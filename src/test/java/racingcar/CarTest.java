package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.number_generator.SpecificNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("값이 4 이상일 경우 전진한다")
    public void 값이_4_이상일_경우_전진한다(int number) throws Exception {
        Car car = new Car("chan", new SpecificNumberGenerator(number));

        car.progress();

        assertThat(car.isSameDistance(1)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("값이 3 이하일 경우 멈춘다.")
    public void 값이_3_이하일_경우_멈춘다(int number) throws Exception {
        Car car = new Car("chan", new SpecificNumberGenerator(number));

        car.progress();

        assertThat(car.isSameDistance(0));
    }
}
