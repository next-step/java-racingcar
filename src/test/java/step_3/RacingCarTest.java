package step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("레이싱 카 객체 생성")
    void createRacingCar() {
        assertThat(new RacingCar(1)).isInstanceOf(RacingCar.class);
    }

    @Test
    @DisplayName("레이싱 카 객체 생성 시, 음수 예외 처리")
    void racingCarThrowNegativeArg() {
        assertThatThrownBy(() -> new RacingCar(-1)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "레이싱 카 정지 - {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int roundResult) {
        RacingCar racingCar = new RacingCar(1);
        racingCar.stopOfForward(0, roundResult);
        assertThat(racingCar.forwardHistory()).isEqualTo(0);
    }

    @ParameterizedTest(name = "레이싱 카 전진 - {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void forward(int roundResult) {
        RacingCar racingCar = new RacingCar(1);
        racingCar.stopOfForward(0, roundResult);
        assertThat(racingCar.forwardHistory()).isEqualTo(1);
    }

    @ParameterizedTest(name = "회차 별 결과 기록 시, 음수 예외 처리 - {0}:{1}")
    @CsvSource(value = {"-1:0", "-1:-1", "0:-1"}, delimiter = ':')
    void stopOrForwardThrowNegativeArgs(int thisRound, int roundResult) {
        RacingCar racingCar = new RacingCar(1);
        assertThatThrownBy(() -> racingCar.stopOfForward(thisRound, roundResult)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("현재 회차의 전진 이력")
    void forwardHistory() {
        // given
        int totalRound = 7;
        RacingCar racingCar = new RacingCar(totalRound);

        // when
        IntStream.range(0, totalRound).forEach(thisRound -> racingCar.stopOfForward(thisRound, thisRound));

        // then
        assertThat(racingCar.forwardHistory()).isEqualTo(3);
    }
}
