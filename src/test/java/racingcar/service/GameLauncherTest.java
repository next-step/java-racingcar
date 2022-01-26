package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.Application;
import racingcar.domain.Car;
import racingcar.domain.RandomConfigTest;
import racingcar.util.RandomUtil;

class GameLauncherTest extends RandomConfigTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 모든차앞으로전진() {
        GameLauncher gameLauncher = new GameLauncher(Arrays.asList("qwe", "asdf", "zx"), 3);
        try (final MockedStatic<RandomUtil> mockRandoms = mockStatic(RandomUtil.class)) {
            mockRandoms
                .when(() -> RandomUtil.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(5, 3, 6);

            gameLauncher.moveForwardAll();

            List<Car> racingCars = gameLauncher.getRacingCarList();
            assertThat(racingCars.get(0).getPosition()).isEqualTo(1);
            assertThat(racingCars.get(1).getPosition()).isZero();
            assertThat(racingCars.get(2).getPosition()).isEqualTo(1);
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
