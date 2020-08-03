package racing.domain;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 인스턴스 생성시에 위치를 확인한다")
    @Test
    void newCar() {
        Car initCar = new Car();

        assertThat(initCar.getLocation()).isZero();
    }

    @DisplayName("자동차 위치와 함께 인스턴스 생성시에 위치를 확인한다")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2"})
    void newCar(int location, int expectedLocation) {
        Car car = new Car(location);

        assertThat(car.getLocation()).isEqualTo(expectedLocation);
    }

    @DisplayName("자동차가 랜덤수가 4이상이면 움직인다")
    @ParameterizedTest
    @CsvSource({"1,0", "2,0", "3,0", "4,1", "5,1"})
    void move(int randomNumber, int expectValue) {
        Car car = new Car();
        car.move(randomNumber);

        assertThat(car.getLocation()).isEqualTo(expectValue);
    }

    @DisplayName("자동차의 현재 위치에 따라 -를 출력한다")
    @ParameterizedTest
    @CsvSource({"0, ''", "1,-", "2,--", "3,---"})
    void printLocation(int randomNumber, String expectValue) {
        Car car = new Car(randomNumber);

        assertThat(car.printLocation()).isEqualTo(expectValue);
    }
}
