package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingCars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱카 클래스 테스트")
class RacingCarsTest {

    @Test
    @DisplayName("자동차 대수 테스트")
    void racingCarSizeTest() {
        int carCount = 4;
        String[] array = {"test1", "test2", "test3"};
        RacingCars racingCars = new RacingCars(array);
        assertThat(racingCars.getCarList()).hasSize(carCount);
    }
}