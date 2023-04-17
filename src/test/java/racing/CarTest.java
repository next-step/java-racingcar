package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest(name = "조건이 4 이상일 경우에만 전진한다")
    @CsvSource(value = {"1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    void isMove(int condition, int location) {
        final Car car = new Car(new CarName("testCar"));
        car.move(condition);

        assertThat(car.getCurrentLocation())
                .isEqualTo(location);
    }

    @Test
    @DisplayName("각 자동차에 이름 부여")
    void carName() {
        final String carName = "testCar";
        final Car car = new Car(new CarName(carName));

        assertThat(car)
                .extracting("carName")
                .extracting("name")
                .isEqualTo(carName);
    }
}
