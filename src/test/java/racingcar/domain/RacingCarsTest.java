package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarsTest {

    @ParameterizedTest
    @DisplayName("1회 경주를 진행한다.")
    @CsvSource(value = {"4, 4, 3, 3", "3, 3, 2, 2"})
    void race_once(int randomNumber, long position1, long position2, long position3) {
        // given
        List<RacingCar> result = createRacingCars();
        RacingCars racingCars = new RacingCars(result);

        // when
        racingCars.raceOnce(new DoubleRandomService(randomNumber));

        // then
        assertThat(result).isEqualTo(Arrays.asList(
                new RacingCar("k3", position1),
                new RacingCar("k5", position2),
                new RacingCar("k7", position3)
        ));
    }

    private List<RacingCar> createRacingCars() {
        return Arrays.asList(
                new RacingCar("k3", 3),
                new RacingCar("k5", 2),
                new RacingCar("k7", 2)
        );
    }

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

    @Test
    @DisplayName("우승자를 알려준다.")
    void find_winners() {
        // given
        RacingCars racingCars = new RacingCars(createRacingCars());

        // when
        List<String> result = racingCars.findWinners();

        // then
        assertThat(result).isEqualTo(List.of("k3"));
    }
}