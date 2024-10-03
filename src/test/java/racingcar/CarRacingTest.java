package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarRacing;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private final CarRacing carRacing = new CarRacing();
    
    @Test
    @DisplayName("자동차들의 상태를 저장할 배열을 만드는 메서드 테스트")
    public void makeCarsStatusArr() {
        carRacing.makeCarsStatusArr(3);
        assertThat(carRacing.getCarsStatus()).hasSize(3);
    }

    @Test
    @DisplayName("자동차들의 움직임을 결정하기 위한 1~9까지의 랜덤한 숫자를 발생시키는 메서드 테스트")
    public void generateRandomNumberForMovingCarTest() {
        int[] randomNumbers = carRacing.generateRandomNumberForMovingCar(3);

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
    @DisplayName("각각의 자동차에 대한 전진여부에 따라 실제로 자동차들을 이동시키고 자동차 상태 배열에 저장하는 메서드 테스트")
    public void saveCarsStatus() {
        carRacing.makeCarsStatusArr(3);
        Car[] carsStatus = carRacing.getCarsStatus();

        boolean[] carForwardStatuses1 = {true, false, true};
        carRacing.saveCarsStatus(carForwardStatuses1);

        assertThat(carsStatus[0].currentCarMovingStatus).isEqualTo("-"); // 첫 번째 자동차는 전진했으므로 "-"
        assertThat(carsStatus[1].currentCarMovingStatus).isEqualTo(""); // 두 번째 자동차는 전진하지 않았으므로 "-"
        assertThat(carsStatus[2].currentCarMovingStatus).isEqualTo("-"); // 세 번째 자동차는 전진했으므로 "-"

        boolean[] carForwardStatuses2 = {false, true, true};
        carRacing.saveCarsStatus(carForwardStatuses2);

        assertThat(carsStatus[0].currentCarMovingStatus).isEqualTo("-"); // 첫 번째 자동차는 여전히 "-"
        assertThat(carsStatus[1].currentCarMovingStatus).isEqualTo("-"); // 두 번째 자동차는 전진했으므로 "-" 추가
        assertThat(carsStatus[2].currentCarMovingStatus).isEqualTo("--"); // 세 번째 자동차는 전진했으므로 "-" 추가
    }
}
