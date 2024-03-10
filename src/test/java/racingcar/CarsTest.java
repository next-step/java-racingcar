package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.interfaces.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("입력받은 횟수만큼 자동차들을 생성하는 Cars Test")
    @ValueSource(ints = {1, 2})
    void makeCarsTest(int input) {
        // when
        Cars cars = new Cars(input);

        // then
        assertThat(cars).hasSize(input);
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수를 Car가 받고 Car 이동 명령 (정지) Test")
    @CsvSource(value = {"1:1", "1:2", "1:3"}, delimiter = ':')
    void orderStopCarsTest(int tryNumber, int moveNumber) {
        // given
        Cars cars = new Cars(5);

        // when
        cars.tryMove(tryNumber, () -> moveNumber);

        // then
        assertThat(cars).extracting("distance").containsExactly(1,1,1,1,1);
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수를 Car가 받고 Car 이동 명령 (이동) Test")
    @CsvSource(value = {"1:4", "1:5", "1:6"}, delimiter = ':')
    void orderMoveCarsTest(int tryNumber, int moveNumber) {
        // given
        Cars cars = new Cars(5);

        // when
        cars.tryMove(tryNumber, () -> moveNumber);

        // then
        assertThat(cars).extracting("distance").containsExactly(2,2,2,2,2);
    }

    static class TestMoveStrategy implements MoveStrategy {
        private final int moveNumber;

        TestMoveStrategy(int moveNumber) {
            this.moveNumber = moveNumber;
        }

        @Override
        public int getMoveNumber() {
            return this.moveNumber;
        }
    }
}
