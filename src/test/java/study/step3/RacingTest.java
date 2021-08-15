package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Racing;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingTest {
    Racing racing = new Racing();

    @DisplayName("initCars 메소드 호출하여 입력값과 return list size가 동일한지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void initCarsTest(int carCount) {
        List<Car> cars = racing.initCars(carCount);
        assertEquals(carCount, cars.size());
    }

    @DisplayName("startRace 메소드 실행 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void startRaceTest(int carCount) {
        racing.startRace(racing.initCars(carCount));
    }
}
