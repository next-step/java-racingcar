package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.Application;
import racingcar.util.RandomUtil;

class RacingCarTest extends RandomConfigTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    @DisplayName("자동차 이름 검사 테스트")
    void carNameValidationTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new RacingCar("gdgdgdgdgdg");
            });
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void moveTest() {
        try (final MockedStatic<RandomUtil> mockRandoms = mockStatic(RandomUtil.class)) {
            mockRandoms
                .when(() -> RandomUtil.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(5);
            RacingCar car = new RacingCar("testN");

            car.moveForward();

            assertThat(car.getPosition()).isEqualTo(1);
        }
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
