package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.behavior.CarMovable;
import racing.behavior.Movable;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @DisplayName("자동차 위치 초기화 상태 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = "pobi")
    void initialCar(final String carName) {
        final Car car = Car.of(carName, new CarMovable());

        assertThat(car.getLocation()).isZero();
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"jace", "mia", "noel"})
    void initialCars(final String carName) {
        final Car car = Car.of(carName, new CarMovable());

        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getLocation()).isZero();
    }

    @DisplayName("자동차 이름 5자 초과 했을 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"자동차 이름은", "myCarName"})
    void shouldExceptionForNameLengthGreaterThanMaxLength(final String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.of(carName, new CarMovable()))
                .withMessage("자동차 이름의 길이를 확인해 주세요.");
    }

    @DisplayName("자동차 이름 공백 또는 빈 값일 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"    ", "", "\n", "  \n "})
    void shouldExceptionForNameNullOrEmpty(final String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.of(carName, new CarMovable()))
                .withMessage("자동차 이름의 길이를 확인해 주세요.");
    }

    @DisplayName("자동차 전진 하는 경우 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = "jace")
    void moveCar(final String carName) {
        final Movable movable = () -> true;
        final Car car = new Car(carName, movable);
        car.move();

        assertThat(car.getLocation()).isOne();
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차 전진 하지 않는 경우 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = "noel")
    void notMovingCar(final String carName) {
        final Movable movable = () -> false;
        final Car car = new Car(carName, movable);
        car.move();

        assertThat(car.getLocation()).isZero();
        assertThat(car.getName()).isEqualTo(carName);
    }
}
