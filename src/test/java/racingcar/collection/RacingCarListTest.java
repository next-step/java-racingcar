package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingCarListTest {

    @Test
    @DisplayName("participate 메소드는 레이스에 자동차를 참가시킨다")
    public void 테스트_RacingCarList_participate() {

        RacingCarList carList= new RacingCarList();
        Car car = new Car(new CarTest.TestMoveStrategy());
        carList.participate(car);

        assertTrue(carList.getCars().contains(car));
    }
}