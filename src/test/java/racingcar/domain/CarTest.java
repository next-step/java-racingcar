package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    void stopOrMove() {
        Car car = new Car("kwon");
        int randomValue = beforeSetUp_stopOrMove_And_getRandomValue(car);
        if (4 <= randomValue) {
            Assertions.assertThat(car.getMoveCount()).isEqualTo(1);
        } else if (randomValue < 4) {
            Assertions.assertThat(car.getMoveCount()).isEqualTo(0);
        }
    }

    private int beforeSetUp_stopOrMove_And_getRandomValue(Car car) {
        NumberStrategy numberStrategy = new NumberStrategy();
        car.stopOrMove(numberStrategy);
        int randomValue = numberStrategy.getRandomValue();
        return randomValue;
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
        Assertions.assertThat(cars.getAllCar())
                .extracting(Car::getName)
                .contains("kwon", "park");
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
