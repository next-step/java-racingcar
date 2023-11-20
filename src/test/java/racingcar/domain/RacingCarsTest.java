package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    @Test
    @DisplayName("1회 경주 결과를 알려준다.")
    void create_single_game_result() {
        // given
        RacingCars racingCars = new RacingCars(createRacingCars());

        // when
        String result = racingCars.createGameResult();

        // then
        assertThat(result).isEqualTo(
                "k3 : ---\n"
                        + "k5 : --\n"
                        + "k7 : --\n"
                        + "\n");
    }

    private List<RacingCar> createRacingCars() {
        return Arrays.asList(
                new RacingCar("k3", 3),
                new RacingCar("k5", 2),
                new RacingCar("k7", 2)
        );
    }
}
