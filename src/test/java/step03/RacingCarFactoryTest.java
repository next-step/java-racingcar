package step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarFactoryTest {

    RacingCarFactory racingCarFactory;

    @BeforeEach
    void setRacingCarFactory() {
        racingCarFactory = new RacingCarFactory("car1,car2,car3");
    }

    @Test
    @DisplayName("RacingCarFactory moveCars 이동한 차들 모두 전진하는지 테스트")
    void moveCars() {
        // when
        racingCarFactory.moveCars(() -> true);

        // then
        for (RacingCar racingCar : racingCarFactory.getRacingCars()) {
            assertThat(racingCar.getRacingCarData().getMovingRange()).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("입력한 수만큼 차가 만들어 졌는지")
    void countMakeCars(int carCount) {
        assertThat(racingCarFactory.getRacingCars().size()).isEqualTo(carCount);
    }
}
