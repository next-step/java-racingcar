package racingCar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.dto.RacingGameInfo;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private final String[] names = {"pobi", "crong", "lion"};

    @ParameterizedTest
    @CsvSource(value = {"true,1,1", "false,1,0"})
    void move(boolean isMove, int time, int expected) {
        RacingGame racingGame = new RacingGame(new RacingGameInfo(names, time));

        racingGame.move(() -> isMove);

        int racingCarsCount = (int) racingGame.getRacingCars().getRacingCarList().stream()
                .filter(racingCar -> racingCar.getPosition() == expected).count();
        assertThat(racingCarsCount).isEqualTo(3);
    }
}
