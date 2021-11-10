package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarTest;
import racingcar.strategy.TestMoveStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.CarTest.TEST_CAR_NAME;

class LapResultTest {
    @Test
    @DisplayName("addResult 메소드는 RaceResult 이력을 저장한다")
    public void 테스트_RaceResult_addRacingHistory() {

        LapResult result = new LapResult();
        Car car = new Car(new CarName(TEST_CAR_NAME), new TestMoveStrategy());
        result.addResult(car.getMoveResultDto());

        assertThat(result.getCarPositionResult(car.getName()));
    }
}