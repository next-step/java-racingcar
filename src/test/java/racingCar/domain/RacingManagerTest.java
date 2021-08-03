package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

    @DisplayName("경주차 0대 생성 테스트")
    @Test
    void generate_0_car_test() {
        RacingManager racingManager = new RacingManager(new String[]{}, 3);
        assertThat(racingManager.getCarsArraySize()).isEqualTo(racingManager.getCarsArraySize());
        assertThat(racingManager.getCarsArraySize()).isEqualTo(0);
    }

    @DisplayName("이름 있는 경주차 3대 생성 테스트")
    @Test
    void generate_3_car_with_name_test() {
        RacingManager racingManager = new RacingManager(new String[]{"pobi", "crong", "honux"}, 3);
        assertThat(racingManager.getCarsArraySize()).isEqualTo(3);
    }
}
