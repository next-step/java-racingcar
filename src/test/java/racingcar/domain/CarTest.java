package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차 도메인 테스트")
public class CarTest {
    private final String[] CAR_NAMES = {"pobi", "crong", "honux"};
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(CAR_NAMES);
    }

    @DisplayName("랜덤 값에 따라 자동차가 멈추거나 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0","4,1"}, delimiter = ',')
    void stopOrMove(int randomValue, int expected) {
        Car car = new Car("kwon");
        car.stopOrMove(randomValue);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(expected);
    }

    @DisplayName("생성된 자동차를 자동차 리스트에 추가한다.")
    @Test
    void addCar() {
        int existingCarNumber = CAR_NAMES.length;
        cars.addCar(new Car("kwon"));
        Assertions.assertThat(cars.getNumberOfCar()).isEqualTo(existingCarNumber + 1);
    }

    @DisplayName("추가한 자동차들이 자동차 리스트에 존재하는지 확인한다.")
    @Test
    void getAllCar() {
        Car car1 = new Car("kwon");
        Car car2 = new Car("park");
        cars.addCar(car1);
        cars.addCar(car2);
        Assertions.assertThat(cars.getAllCar()).contains(car1, car2);
    }

    @DisplayName("자동차의 이름이 5글자가 넘어가면 예외가 발생한다.")
    @Test
    void inputCarNumberException() {
        String[] carNames = {"sangkwon", "kwon"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cars(carNames);
        });
    }
}
