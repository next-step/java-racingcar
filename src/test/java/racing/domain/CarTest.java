package racing.domain;

import strategy.AboveNumberMove;
import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.RandomNumberGenerator;


import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 인스턴스 생성시에 위치를 확인한다")
    @Test
    void newCar() {
        Car initCar = Car.of("joy", new AboveNumberMove(4, new RandomNumberGenerator()));

        assertThat(initCar.getLocation()).isZero();
    }

    @DisplayName("자동차 위치와 함께 인스턴스 생성시에 위치를 확인한다")
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,2"})
    void newCar(int location, int expectedLocation) {
        Car car = Car.locationOf("joy", location, new AboveNumberMove(0, new RandomNumberGenerator()));

        assertThat(car.getLocation()).isEqualTo(expectedLocation);
    }

    @DisplayName("자동차가 랜덤수가 4 이상이면 움직인다")
    @ParameterizedTest
    @CsvSource({"1, 0", "2, 0", "3, 0", "4, 1", "5, 1"})
    void move(int randomNumber, int expectValue) {
        Car car = Car.of("joy", new AboveNumberMove(4, () -> randomNumber));

        car.move();

        assertThat(car.getLocation()).isEqualTo(expectValue);
    }
}
