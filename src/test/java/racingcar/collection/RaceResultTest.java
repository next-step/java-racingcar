package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarTest;

class RaceResultTest {
    @Test
    @DisplayName("setResult 메소드는 RaceResult 이력을 저장한다")
    public void 테스트_RaceResult_addRacingHistory() {

        RaceResult result = new RaceResult();
        result.addResult(new Car(new CarTest.TestMoveStrategy()));
    }
}