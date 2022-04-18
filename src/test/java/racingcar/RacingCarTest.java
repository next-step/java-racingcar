package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RacingCarTest {

    @Test
    @DisplayName("입력한 size만큼 RacingCar 객체 생성되는지 확인")
    void createBatch() {
        RacingCar[] racingCars = RacingCar.createBatch(3);

        Assertions.assertThat(racingCars).hasSize(3);
    }

}