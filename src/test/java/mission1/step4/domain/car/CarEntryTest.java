package domain.car;

import mission1.step4.algorithm.MoveByRandomValue;
import mission1.step4.algorithm.MoveStrategy;
import mission1.step4.algorithmForTest.MoveStrategyCacheForTest;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CarEntryTest {

    @DisplayName("레이스 승자 찾기")
    @Test
    public void carRaceWinnerCheck() {
        // given
        CarEntry carEntry = new CarEntry();
        Car car1 = Car.create("test1");
        Car car2 = Car.create("test2");

        carEntry.regist(car1);
        carEntry.regist(car2);

        // when
        car1.move(() -> true);
        car1.move(() -> true);

        car2.move(() -> true);
        car2.move(() -> false);

        assertEquals(carEntry.getRaceWinner().get(0), car1);
    }
}





