package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    @DisplayName("자동차 경주 게임 한 라운드 진행")
    @Test
    void play_one_round() {
        CarList cars = new CarList("pobi,crong,honux");
        assertThat(cars.playOneRound(new TestNumberGenerator(
                List.of(0, 2, 1)
        ))).containsExactly("pobi : -", "crong : -", "honux : -");
    }
}
