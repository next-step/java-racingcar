package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 객체는 CarName 객체를 받아 생성된다")
    @Test
    void createCarWithCarName() {
        CarName carName = new CarName("car1");
        Car car = new Car(carName);
        assertThat(car).isNotNull();
        assertThat(car.name()).isEqualTo(carName);
        assertThat(car.position().asInt()).isEqualTo(0);
    }

    @DisplayName("값이 4 이상일 때 자돋차가 이동한다")
    @ParameterizedTest
    @CsvSource({"0,0", "3,0", "4,1", "9,1"})
    void canMoveWhenAtLeast(int number, int expected) {
        Car car = new Car(new CarName("car1"));
        car.moveIfPossible(number);
        assertThat(car.position()).isEqualTo(new Position(expected));
    }
}