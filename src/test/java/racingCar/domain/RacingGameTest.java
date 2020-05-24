package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("자동차 Name 설정")
    void initRacingCars() {
        String[] names = {"pobi", "crong", "lion"};
        RacingGame racingGame = new RacingGame(names, 3);

        List<String> racingCarNames = racingGame.getRacingCarList().stream()
                                                .map(RacingCar::getName)
                                                .collect(Collectors.toList());

        assertThat(racingCarNames).hasSize(names.length)
                                .hasSameElementsAs(Arrays.asList(names));
    }

    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    void move(boolean isMove, int expected) {
        String[] names = {"pobi", "crong", "lion"};
        RacingGame racingGame = new RacingGame(names, 3);
        List<RacingCar> racingCarList = racingGame.getRacingCarList();

        racingGame.move(() -> isMove);

        racingCarList = racingCarList.stream()
                                    .filter(racingCar -> racingCar.getPosition() == expected)
                                    .collect(Collectors.toList());

        assertThat(racingCarList.size()).isEqualTo(3);
    }
}
