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

    private RacingGame racingGame;

    @BeforeEach
    void create_racing_game_instance() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("입력한 자동차 대수와 같은 자동차 리스트가 생성되었는지 및 초기 위치 테스트")
    void is_equal_to_car_number() {
        List<Car> cars = RacingGame.makeCarList(10);
        assertThat(cars.size()).isEqualTo(10);
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

    @Test
    @DisplayName("전진 조건이 아닌 경우 자동차가 멈추는지 테스트")
    void stop() {
        Car car = new Car(0);

//        assertThat()
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 게임 테스트")
    @CsvSource(value = {"3,5", "4,6"})
    void test_racing_game (int numberOfCar, int round) {
        // given

        // when

        // then

    }

}