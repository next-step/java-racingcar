package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("자동차 수가 1 미만이면 IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"5, 0", "10, 0", "100, 0"})
    void readyGame_CarCountLessThan0_Then_IllegalArgumentException(int time, int carCount) {
        List<Car> cars = TestCarFactory.createList(carCount);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(time, cars));
    }

    @DisplayName("이동 횟수가 1 미만이면 IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"0, 5", "0, 10", "0, 100"})
    void readyGame_timeLessThan0_Then_IllegalArgumentException(int time, int carCount) {
        List<Car> cars = TestCarFactory.createList(carCount);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(time, cars));
    }

    @DisplayName("게임이 실행되면 설정한 실행 횟수만큼의 결과 목록을 리턴한다")
    @Test
    void run() {
        int time = 5, carCount = 3;
        List<Car> cars = TestCarFactory.createList(carCount);
        RacingGame game = new RacingGame(time, cars);

        List<CarPositions> results = game.run();

        assertThat(results.size()).isEqualTo(time);
    }
}
