package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;
import step3.model.Cars;
import step3.utils.RacingUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static final int TEST_CAR_COUNT_VALUE = 3;
    private static final int MAX_BOUND = 10;
    private static int ZERO = 0;

    private Cars TestCar;

    private void init(int carCount) {
        TestCar = Cars.generateCars(carCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 입력된_숫자만큼의_Car_생성(int count) {
        init(count);
        assertThat(TestCar.getCars().size()).isEqualTo(count);
    }

    @Test
    void 자동차_이동_테스트() {
        {
            Car car = new Car(ZERO);
            car.availableForward(5);
            Assertions.assertThat(car.getDistance()).isEqualTo(++ZERO);
        }
        {
            Car car = new Car(ZERO);
            car.availableForward(2);
            Assertions.assertThat(car.getDistance()).isEqualTo(ZERO);
        }
    }

    @Test
    void 자동차들_이동_테스트() {
        init(TEST_CAR_COUNT_VALUE);

        for (Car car : TestCar.getCars()) {
            int before = car.getDistance();
            int randomNumber = RacingUtils.generateRandomNumber(MAX_BOUND);
            car.availableForward(randomNumber);

            int after = car.getDistance();

            if (!RacingUtils.isOverLimit(randomNumber)) {
                assertThat(after).isEqualTo(before);
            }

            if (RacingUtils.isOverLimit(randomNumber)) {
                assertThat(after).isEqualTo(++before);
            }
        }

    }

}
