package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.model.RacingCar;
import racingcar.model.Rule;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingCarTest {

    private RacingCar racingCar;

    @BeforeAll
    void setUp() {
        racingCar = new RacingCar("TEST_CAR");
    }

    @Test
    @DisplayName("자동자 주행 테스트")
    void runTest() {
        // given
        Rule testRule = () -> true;

        // when
        racingCar.run(testRule);

        // then
        assertThat(racingCar.getCarPosition()).isPositive();
    }

}