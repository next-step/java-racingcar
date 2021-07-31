package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

    @DisplayName("경주차 0대 생성 테스트")
    @Test
    void generate_0_car_test() {
        RacingManager racingManager = new RacingManager();
        racingManager.generateCars();
        assertThat(racingManager.getCarsArraySize()).isEqualTo(racingManager.getNumberOfCar());
        assertThat(racingManager.getCarsArraySize()).isEqualTo(0);
    }

    @DisplayName("경주차 4대 생성 테스트")
    @Test
    void generate_4_car_test() {
        RacingManager racingManager = new RacingManager(4);
        racingManager.generateCars();
        assertThat(racingManager.getCarsArraySize()).isEqualTo(racingManager.getNumberOfCar());
        assertThat(racingManager.getCarsArraySize()).isEqualTo(4);
    }

}
