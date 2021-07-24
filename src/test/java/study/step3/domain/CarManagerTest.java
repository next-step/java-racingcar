package study.step3.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarManagerTest {

    CarManager carManager = new CarManager();

    @ParameterizedTest(name = "입력한 수 만큼 Car 를 모집 | {arguments}")
    @CsvSource(value = {"3:3", "5:5"}, delimiter = ':')
    public void getCars(int carNumber, int expected) {
        // given
        int startPosition = 0;

        // when
        List<Car> cars = carManager.getCars(carNumber);

        // then
        assertThat(cars)
                .doesNotContainNull()
                .hasSize(expected)
                .allMatch(car -> isCarPositionEqualTo(car, startPosition));
    }

    @ParameterizedTest(name = "입력한 수 가 0보다 작은 경우 | {arguments}")
    @ValueSource(ints = {0, -1, -3})
    public void illegalCarNumber(int carNumber) {
        // given

        // when
        ThrowingCallable throwingCallable = () -> carManager.getCars(carNumber);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarManager.ILLEGAL_CAR_NUMBER + carNumber);
    }

    private boolean isCarPositionEqualTo(Car car, int position) {
        return car.getPosition() == position;
    }
}
