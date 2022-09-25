package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ResultView;
import racingcar.domain.Car;
import racingcar.domain.CarFacility;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @Test
    @DisplayName("랜덤값이 4 미만일 때")
    public void inputZeroNum() {
        Car car = new Car();
        boolean result = car.isMoveAble(3);
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("차량이 2회 이동할 때")
    public void moveTwoTimes() {
        Car car = new Car();
        car.moveCar(true);
        car.moveCar(true);
        assertThat(car.positionView).isEqualTo("--");
    }

    @Test
    @DisplayName("차량 대수가 3대일 때 리스트 길이")
    public void countCarNum() {
        CarFacility carFacility = new CarFacility();
        List<Car> carList = carFacility.buildCar(3);
        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("차량 위치 테스트")
    public void checkCarPosition() {
        CarFacility carFacility = new CarFacility();
        ResultView resultView = new ResultView();
        List<Car> carList = carFacility.buildCar(3);


    }
}
