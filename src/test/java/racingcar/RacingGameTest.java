package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임에 참여할 자동차들을 입력한다.")
    void racingGame() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        List<Vehicle> cars = List.of(car1, car2);

        //when
        Game game = new RacingGame(cars);

        //then
        assertThat(game.getVehicles().size()).isEqualTo(cars.size());
    }
}