package step4.service;

import org.junit.jupiter.api.Test;
import step4.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    void RacingCarGame_객체_생성시_name을_통해_자동차를_정상적으로_초기화한다() {
        final String name = "pobi,crong,honux";

        final RacingCarGame game = new RacingCarGame(name);
        final List<Car> cars = game.getCars();

        assertThat(cars).hasSize(3);
    }

}