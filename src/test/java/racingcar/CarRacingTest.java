package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarRacing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private final CarRacing carRacing = new CarRacing(3);
    
    @Test
    @DisplayName("자동차들의 상태를 저장할 배열을 만드는 메서드 테스트")
    public void makeCarsStatusArr() {
        carRacing.makeCarsStatusList(5);
        assertThat(carRacing.getCarsStatus()).hasSize(5);
    }

    @Test
    @DisplayName("자동차들의 움직임을 결정하기 위한 1~9까지의 랜덤한 숫자를 발생시키는 메서드 테스트")
    public void generateRandomNumberForMovingCarTest() {
        int[] randomNumbers = carRacing.generateRandomNumberForMovingCar(5);

        for(int carNumber : randomNumbers) {
            assertThat(carNumber).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("발생한 랜덤한 값들을 기반으로 자동차들의 전진 여부를 결정하는 메서드 테스트")
    public void isCarMovingForwardTest() {
        boolean[] carForwardStatuses = carRacing.isCarMovingForward(carRacing.generateRandomNumberForMovingCar(3));

        for(boolean carForwardStatus : carForwardStatuses) {
            assertThat(carForwardStatus).isIn(true, false);
        }
    }

    @Test
    @DisplayName("각각의 자동차에 대한 전진여부에 따라 실제로 자동차들을 이동시키는 메서드 테스트")
    public void carMove() {
        carRacing.makeCarsStatusList(3);
        List<Car> carsStatus = carRacing.getCarsStatus();

        boolean[] carForwardStatuses1 = {true, false, true};

        for(int i = 0; i < carsStatus.size(); i++) {
            Car car = carsStatus.get(i);
            car.move(carForwardStatuses1[i]);
        }

        assertThat(carsStatus.get(0).getCarMovingDistance()).isEqualTo(1);
        assertThat(carsStatus.get(1).getCarMovingDistance()).isEqualTo(0);
        assertThat(carsStatus.get(2).getCarMovingDistance()).isEqualTo(1);

        boolean[] carForwardStatuses2 = {false, true, true};

        for(int i = 0; i < carsStatus.size(); i++) {
            Car car = carsStatus.get(i);
            car.move(carForwardStatuses2[i]);
        }

        assertThat(carsStatus.get(0).getCarMovingDistance()).isEqualTo(1);
        assertThat(carsStatus.get(1).getCarMovingDistance()).isEqualTo(1);
        assertThat(carsStatus.get(2).getCarMovingDistance()).isEqualTo(2);
    }
}
