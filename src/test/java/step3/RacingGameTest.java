package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}