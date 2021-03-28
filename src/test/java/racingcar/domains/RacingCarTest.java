package racingcar.domains;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0", "5:1", "0:0", "9:1"}, delimiter = ':')
    void racingCarRandomMoveTest(int randomNum, int resultMoveCnt) {
        RacingCar racingCar = new RacingCar();
        racingCar.move(randomNum);

        assertThat(racingCar.getMoveCnt()).isEqualTo(resultMoveCnt);
    }
}