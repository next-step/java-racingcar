package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.Application;
import racingcar.util.RandomUtil;

class RacingCarTest extends RandomConfigTest{

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 자동차이름_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar("gdgㅗㅓㅏ,ㅗㅓㅜㅡg");
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
