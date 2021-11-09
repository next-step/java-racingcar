package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarTest;
import racingcar.strategy.TestMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarTest.TEST_CAR_NAME;

class LapResultResultTest {
    @Test
    @DisplayName("addResult 메소드는 자동차의 레이스 결과, 즉 자동차의 위치를 저장한다")
    public void 테스트_RaceHistories_addResult() {

        LapResult result = new LapResult();
        Car car = new Car(new CarName(TEST_CAR_NAME), new TestMoveStrategy());
        result.addResult(car.getMoveResultDto());

        assertThat(result.getCarPositionResult(car.getName()))
                .isEqualTo(car.getCurrentPositionValue());
    }

    @Test
    @DisplayName("getCarPositionResult 메소드는 자동차의 레이스 결과, 즉 자동차의 위치를 반환 한다")
    public void 테스트_RaceHistories_getCarPositionResult() {

        LapResult result = new LapResult();
        Car car = new Car(new CarName(TEST_CAR_NAME), new TestMoveStrategy());
        car.move();

        result.addResult(car.getMoveResultDto());

        assertThat(result.getCarPositionResult(car.getName())).isEqualTo(1);
    }
}