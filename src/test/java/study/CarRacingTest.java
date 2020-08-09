package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;
import racingcar.Cars;
import racingcar.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private Car car;

    @BeforeEach
    void setting(){
        car = new Car();
    }

    @DisplayName("랜덤값이 4이상이면 차가 움직이게 되는지")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void changeOfCarStatus(int random){
        car.move(random);
        assertThat(car.getStatusLine()).isGreaterThan(0);
    }

    @DisplayName("랜덤값이 3이하일 경우 차가 움직이지 않는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void notChangeOfCarStatus(int random){
        car.move(random);
        assertThat(car.getStatusLine()).isZero();
    }

    @DisplayName("INPUT값만큼 차가 생성되었는지")
    @ParameterizedTest
    @ValueSource(ints = {2,4,6})
    void makeCar(int count){
        int expectValue = count;
        Cars cars = new Cars(count);
        assertThat(cars.stream().count()).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("랜덤값이 0~9사이에서 실행되는지 확인")
    void call_random_number() {
        assertThat(RacingGame.randomNumber()).isLessThan(10);
        assertThat(RacingGame.randomNumber()).isBetween(0, 10);
        assertThat(RacingGame.randomNumber()).isGreaterThan(0);
    }

}
