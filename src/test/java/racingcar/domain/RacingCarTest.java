package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingCarTest extends RandomConfigTest{

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 자동차이름_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar("gdgdasdag");
            });
    }

    @Test
    void 앞으로전진() {
            RacingCar car = new RacingCar("testN");
            car.moveForward(5);
            assertThat(car.getPosition()).isEqualTo(1);

    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
