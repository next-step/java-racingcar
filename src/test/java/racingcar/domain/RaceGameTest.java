package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceGameTest {

    @DisplayName("참여한 자동차 수 확인")
    @Test
    void join() {
        Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));

        RaceGame game = new RaceGame(cars);

        assertThat(game.joinCount()).isEqualTo(3);
    }
}
