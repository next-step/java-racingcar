package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RacingCarGameTest {
    private static final int CAR_MOVE_THRESHOLD = 4;

    @Test
    @DisplayName("자동차들이 최대 입력된 시도 회수만큼 움직여야 한다")
    void process() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        carList.add(new Car());

        int tryCount = 3;
        new RacingCarGame(carList, tryCount, new ResultView()).startGame(new RandomForTest(CAR_MOVE_THRESHOLD));
        Assertions.assertThat(carList).allMatch(car -> car.getPosition() == tryCount);
    }

    private static class RandomForTest extends Random {
        private final int returnNumber;

        RandomForTest(int returnNumber) {
            this.returnNumber = returnNumber;
        }

        @Override
        public int nextInt(int bound) {
            return returnNumber;
        }
    }
}