package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Winners;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnersTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        String inputCarNames = "car1,car2,car3";
        cars = new Cars(new CarNames(inputCarNames.split(",")));
        TestMoveStrategy moveStrategy = new TestMoveStrategy(5);
        cars.tryMove(1, moveStrategy);
    }

    @Test
    void winnerTest() {
        Winners winners = new Winners(cars);

        assertThat(winners.getWinnersNames()).isEqualTo("car1, car2, car3");
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