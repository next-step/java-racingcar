package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.CarTest.TEST_CAR_NAME;

class RacingCarListTest {

    @Test
    @DisplayName("participate 메소드는 레이스에 자동차를 참가시킨다")
    public void 테스트_RacingCarList_participate() {

        RacingCarList carList= new RacingCarList();
        Car car = new Car(new CarName(TEST_CAR_NAME), new CarTest.TestMoveStrategy());
        carList.participate(car);
    }
}