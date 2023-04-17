package race.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.car.dto.CarInfoDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {
    final String carName = "testCar";
    final int moveCondition = 4;
    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(new Name(carName));
    }

    @ParameterizedTest(name = "조건이 4 이상일 경우에만 전진한다")
    @CsvSource(value = {"1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    void isMove(int condition, int location) {
        car.move(condition);

        assertThat(car)
                .extracting("location")
                .extracting("location")
                .isEqualTo(location);
    }

    @Test
    @DisplayName("각 자동차에 이름 부여")
    void carName() {
        assertThat(car)
                .extracting("name")
                .extracting("name")
                .isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차의 현재 위치와 함께 이름도 같이 리턴")
    void currentLocation() {
        car.move(moveCondition);

        assertAll(
                () -> assertThat(car.currentCarInfo())
                        .isInstanceOf(CarInfoDto.class),
                () -> assertThat(car.currentCarInfo())
                        .extracting("location")
                        .isEqualTo(1),
                () -> assertThat(car.currentCarInfo())
                        .extracting("name")
                        .isEqualTo(carName)
        );
    }
}
