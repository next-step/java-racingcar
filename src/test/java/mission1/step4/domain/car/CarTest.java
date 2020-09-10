package mission1.step4.domain.car;

import mission1.step3.command.CommandFactory;
import mission1.step4.CarRace;
import mission1.step4.algorithm.MoveByRandomValue;
import mission1.step4.algorithm.MoveStrategy;
import mission1.step4.algorithmForTest.MoveStrategyCacheForTest;
import mission1.step4.algorithmForTest.MoveStrategyProgressForTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 생성시 이름이 5자를 초과할 경우")
    @Test
    public void createCarByIllegalName() {
        assertThrows(IllegalArgumentException.class, () -> Car.create("testtest"));
    }

    @DisplayName("자동차 전진여부 체크")
    @ParameterizedTest(name="{index} {displayName} 제공값={0} {1} {2}, 결과={3}")
    @CsvSource({"1, 2, 3, 0", "4, 4, 6, 3", "3, 3, 4, 1"})
    public void carProgressCheck(int randomValue1, int randomValue2, int randomValue3, int expectedProgress) {
        Car car = Car.create("test");
        car.move(MoveStrategyCacheForTest.getMoveByRandomValue(randomValue1));
        car.move(MoveStrategyCacheForTest.getMoveByRandomValue(randomValue2));
        car.move(MoveStrategyCacheForTest.getMoveByRandomValue(randomValue3));
        assertEquals(car.getProgress(), expectedProgress);
    }
}



