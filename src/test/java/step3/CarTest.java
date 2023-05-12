package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.util.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//todo : CarOperator.drivingResult 테스트 코드 어떻게 짤 지 고민하기
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
        Assertions.assertTrue(Car.willMoving(9));
        Assertions.assertTrue(Car.willMoving(4));
        Assertions.assertFalse(Car.willMoving(3));
        Assertions.assertFalse(Car.willMoving(0));
    }


    @Test
    @DisplayName("조건이 true인 경우 1이 추가되고, 그렇지 않은 경우 0이 추가되는지 확인")
    public void checkGenerateMoving() {
        int numOfCars = 5;
        List<Car> carList = Car.factory(numOfCars);

        for (Car car : carList) {
            int randomNumber = NumberGenerator.makeRandomly();
            car.drive(randomNumber);
            if (Car.willMoving(randomNumber)) {
                Assertions.assertTrue(car.getMovingList().contains(1));
            } else {
                Assertions.assertTrue(car.getMovingList().contains(0));
            }
        }
    }
}
