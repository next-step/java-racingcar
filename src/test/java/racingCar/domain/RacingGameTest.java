package racingCar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.domain.car.RacingCars;
import racingCar.dto.RacingGameInfo;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private final String[] names = {"pobi", "crong", "lion"};

    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    void move(boolean isMove, int expected) {
        RacingGame racingGame = new RacingGame(new RacingGameInfo(names, 3));

        racingGame.move(() -> isMove);

        RacingCars racingCars = racingGame.getRacingCars();
        int racingCarsCount = (int) racingCars.getRacingCarList().stream()
                                            .filter(racingCar -> racingCar.getPosition() == expected).count();

        assertThat(racingCarsCount).isEqualTo(3);
    }
}
