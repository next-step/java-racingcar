package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "9,1", "0,0"})
    @DisplayName("주어진 숫자에 맞게 자동차가 진행했는지 테스트")
    public void move(String input, String expected) {
        // given
        RacingCar racingCar = new RacingCar("test1");

        // when
        racingCar.move(Integer.parseInt(input));

        // then
        assertThat(racingCar.getDistance()).isEqualTo(Integer.parseInt(expected));
    }
}
