package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {

    private static final int CAR_MOVE_BOUND = 4;

    @Test
    @DisplayName("자동차들이 최대 tryCount만큼 움직여야 한다")
    void process() {
        List<Car> carsForTest = List.of(
                Car.of("pobi"),
                Car.of("crong")
        );
        int tryCount = 3;
        new RacingGame(carsForTest, tryCount, new ResultView(), new WinnerCarSelector()).process(new RandomForTest(CAR_MOVE_BOUND));
        Assertions.assertThat(carsForTest).allMatch(car -> car.getPosition() == tryCount);
    }
}
