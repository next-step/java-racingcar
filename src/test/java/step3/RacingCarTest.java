package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;
import step3.domain.CarFactory;
import step3.utils.RandomUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("사용자가 입력한 숫자만큼 자동차가 생성되야 한다.")
    void initCarsInputNumber() {
        List<Car> cars = CarFactory.createCars(3);
        assertThat(cars).hasSize(3);
    }

    @Test
    @DisplayName("생성된 자동차의 기본 포지션은 1 이어야 한다.")
    void initCarPositionIs1() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값은 0 ~ 9 사이어야 한다.")
    void randomNumberBetween0to9() {
        for(int i = 0; i < 100; i++) {
            assertThat(RandomUtils.generateRandomNumber()).isBetween(0, 9);
        }
    }

    @ParameterizedTest
    @DisplayName("4 이상인 경우 자동차는 전진한다.")
    @CsvSource(value = {"1,1", "4, 2", "9, 2"}, delimiter = ',')
    void racingCarMoveForward(int value, int expected) {
        Car car = new Car();
        car.tryMove(value);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

}
