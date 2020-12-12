package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("이름이 다섯글자 이상이 왔을 때 오류가 발생하는지 테스트")
    public void createNamedRacingCarsNameOverFiveError() {
        // given
        String tester = "tester";

        // when
        Throwable thrown = catchThrowable(() -> {
            new RacingCar(tester);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("이름의 길이가 적절하지 않습니다.");
    }
}
