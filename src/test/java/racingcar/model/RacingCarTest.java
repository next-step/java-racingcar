package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.MockCarMoverTest.mockMover;

public class RacingCarTest {

    private RacingCar racingCar;

    @Test
    @DisplayName("2번째 플레이에 대한 결과를 반환한다.")
    void onePlayByResult() {
        RacingCar racingCar = RacingCar.of(3, 2, mockMover(4, 3, 8, 9));
        List<Car> result = play(racingCar, 2);
        assertThat(result.get(0).getPosition()).isEqualTo(2);
        assertThat(result.get(1).getPosition()).isEqualTo(1);
    }

    private List<Car> play(RacingCar racingCar, int count) {
        List<Car> result = null;
        for (int i = 0; i < count; i++) {
            result = racingCar.play();
        }
        return result;
    }

    @Test
    @DisplayName("횟수가 0이면 게임종료")
    void timeZeroThenGameOver() {
        racingCar = ofRacingCar(0);
        assertThat(racingCar.isGameOver()).isTrue();
    }

    @Test
    @DisplayName("횟수가 0이 아닐 시 Fail")
    void timeNoZeroThenGameOver() {
        racingCar = ofRacingCar(3);
        assertThat(racingCar.isGameOver()).isFalse();
    }

    private RacingCar ofRacingCar(int time) {
        return RacingCar.of(time, 0, new MockCarMover(Arrays.asList(1, 4, 9, 8, 2, 7)));
    }
}