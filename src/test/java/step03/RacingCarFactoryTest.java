package step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarFactoryTest {

    RacingCarFactory racingCarFactory;

    @BeforeEach
    void setRacingCarFactory() {
        racingCarFactory = new RacingCarFactory("test1,test2,test3");
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
}
