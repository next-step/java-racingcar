package racingcargame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcargame.TestUtil;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    private final RacingCar racingCar = new RacingCar();

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    void moveTest(int moveArgument, int position) {
        racingCar.move(moveArgument);
        int currentPosition = TestUtil.getPrivateField(racingCar, "position");

        assertThat(currentPosition).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource(value = {"23:''", "34:-", "45:--"}, delimiter = ':')
    void getCurrentStateTest(String moveArgumentsString, String state) {
        int[] moveArguments = Arrays.stream(moveArgumentsString.split(""))
                .mapToInt(Integer::parseInt).toArray();

        for (int moveArgument : moveArguments) {
            racingCar.move(moveArgument);
        }

        assertThat(racingCar.getCurrentState()).isEqualTo(state);
    }
}