package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private CarNames carNames;

    @BeforeEach
    void setUp() {
        String inputCarNames = "car1,car2,car3";
        carNames = new CarNames(inputCarNames.split(","));
    }

    @ParameterizedTest
    @DisplayName("입력받은 차 이름에 따라 자동차들을 생성하는 Cars Test")
    void makeCarsTest() {
        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars).hasSize(carNames.getCarNameCount());
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수를 Car가 받고 Car 이동 명령 (정지) Test")
    @CsvSource(value = {"1:1", "1:2", "1:3"}, delimiter = ':')
    void orderStopCarsTest(int tryNumber, int moveNumber) {
        // given
        Cars cars = new Cars(carNames);

        // when
        cars.tryMove(tryNumber, () -> moveNumber);

        // then
        assertThat(cars).extracting("distance").containsExactly(0,0,0,0,0);
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수를 Car가 받고 Car 이동 명령 (이동) Test")
    @CsvSource(value = {"1:4", "1:5", "1:6"}, delimiter = ':')
    void orderMoveCarsTest(int tryNumber, int moveNumber) {
        // given
        Cars cars = new Cars(carNames);

        // when
        cars.tryMove(tryNumber, () -> moveNumber);

        // then
        assertThat(cars).extracting("distance").containsExactly(1,1,1,1,1);
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
