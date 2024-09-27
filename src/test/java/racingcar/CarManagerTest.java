package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarManagerTest {

    @Test
    void 자동차생성_입력대수만큼() {
        int cntOfCar = 3;
        CarManager carManager = new CarManager();

        List<Car> carList = carManager.createCarByCnt(cntOfCar);
        assertThat(carList.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(strings = {"-", "--", "---"})
    @DisplayName("전진 횟수만큼 마일리지 누적 O")
    void move_길이(String mileage) {
        Car car = getCar();

        for (int i = 0; i < mileage.length(); i++) {
            car.move();
        }
        assertThat(car.getTotalMileage()).isEqualTo(mileage);
    }


    @Test
    @DisplayName("멈춤 시 마일리지 누적 X")
    void stop() {
        Car car = getCar();
        car.stop();
        assertThat(car.getTotalMileage()).isEqualTo("");
    }
    

    private static Car getCar() {
        CarManager carManager = new CarManager();
        return carManager.createCarByCnt(1).get(0);
    }

}
