package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.CarOperator;
import step3.util.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 대수만큼 List<Car> 생성되는지 확인")
    public void checkGenerateCarList() {
        int numberOfCars = 5;
        assertThat(Car.factory(numberOfCars).size()).isEqualTo(numberOfCars);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상 나왔을 때만 true 반환하는지 확인")
    public void checkMoveState() {
        Assertions.assertTrue(CarOperator.willMoving(4));
        Assertions.assertTrue(CarOperator.willMoving(9));
        Assertions.assertFalse(CarOperator.willMoving(3));
        Assertions.assertFalse(CarOperator.willMoving(0));
    }


    @Test
    @DisplayName("조건이 true인 경우 해당 자동차에만 '-'가 추가 되었는지 확인")
    public void checkGenerateMoving() {
        int numOfCars = 5;
        int randomNumber = NumberGenerator.makeRandomly();
        List<Car> carList = Car.factory(numOfCars);

        CarOperator.drive(carList);

        for (Car car : carList) {
            if (CarOperator.willMoving(randomNumber)) {
                Assertions.assertTrue(car.getMovingList().contains("-"));
            } else {
                Assertions.assertFalse(car.getMovingList().contains("-"));
            }
        }
    }
}
