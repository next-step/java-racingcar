package domain.car;

import mission1.step4.algorithm.MoveByRandomValue;
import mission1.step4.algorithm.MoveStrategy;
import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CarEntryTest {

    @DisplayName("레이스 참여 엔트리에서 등록된 차량의 수보다 높은 인덱스를 인자로 줬을 때")
    @Test
    public void carEntryOutOfIndexCheck() {
        // given
        CarEntry carEntry = new CarEntry();
        Car car1 = Car.create("test1", new MoveByRandomValue());
        Car car2 = Car.create("test2", new MoveByRandomValue());
        carEntry.regist(car1);
        carEntry.regist(car2);

        assertThrows(IllegalArgumentException.class, () -> carEntry.getCar(3));
    }

    @DisplayName("레이스 승자 찾기")
    @Test
    public void carRaceWinnerCheck() {
        // given
        CarEntry carEntry = new CarEntry();
        Car car1 = Car.create("test1", new MoveByRandomValue());
        Car car2 = Car.create("test2", new MoveByRandomValue());

        carEntry.regist(car1);
        carEntry.regist(car2);

        // when
        car1.move(3);
        car1.move(3);

        car2.move(5);
        car2.move(5);

        assertEquals(carEntry.getRaceWinner().size(), 1);
    }


}



