package race.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.dto.CarInfoDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {
    final String carName = "test";
    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(new Name(carName));
    }

    @Test
    @DisplayName("조건이 true 이면 전진한다.")
    void isMove() {
        car.move(() -> true);

        assertThat(car)
                .extracting("location")
                .isEqualTo(new Location(1));
    }

    @Test
    @DisplayName("조건이 false 이면 전진하지않는다.")
    void isNotMove() {
        car.move(() -> false);

        assertThat(car)
                .extracting("location")
                .isEqualTo(new Location(0));
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
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 발생")
    void carNameMoreThan5() {
        final String carName = "12345";
        final String bigCarName = "123456";

        assertAll(
                () -> assertThat(new Car(new Name(carName)))
                        .isInstanceOf(Car.class),
                () -> assertThatThrownBy(() -> new Car(new Name(bigCarName))).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 현재 위치와 함께 이름도 같이 리턴")
    void currentLocation() {
        car.move(() -> true);

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
