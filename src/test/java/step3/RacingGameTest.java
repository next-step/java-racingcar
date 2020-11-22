package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("입력한 자동차 대수와 같은 자동차 리스트가 생성되었는지 및 초기 위치 테스트")
    @ValueSource(ints = {3,5,10})
    void is_equal_to_car_number(int carNumber) {
        RacingGame racingGame = new RacingGame(carNumber,5);
        List<Car> cars = racingGame.makeCarList(carNumber);
        assertThat(cars.size()).isEqualTo(carNumber);
        cars.forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }

    @ParameterizedTest
    @DisplayName("전진 조건에서 자동차가 전진하는지 테스트")
    @ValueSource(ints = {4,5,6,7,8,9})
    void move_forward(int condition) {
        Car car = new Car(0);
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("전진 조건이 아닌 경우 자동차가 멈추는지 테스트")
    @ValueSource(ints = {0,1,2,3})
    void stop(int condition) {
        Car car = new Car(0);
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}