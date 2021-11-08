package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {
    @Test
    @DisplayName("setResult 메소드는 자동차의 레이스 결과, 즉 자동차의 위치를 저장한다")
    public void 테스트_RaceHistories_addResult() {

        Race result = new Race();
        Car car = new Car("", new CarTest.TestMoveStrategy());
        result.addResult(car);

        assertTrue(result.getCars().contains(car));
    }

    @Test
    @DisplayName("getCarPositionResult 메소드는 자동차의 레이스 결과, 즉 자동차의 위치를 반환 한다")
    public void 테스트_RaceHistories_getCarPositionResult() {

        Race result = new Race();
        Car car = new Car("", new CarTest.TestMoveStrategy());
        car.move();
        result.addResult(car);

        assertThat(result.getCarPositionResult(car)).isEqualTo(1);
    }
}