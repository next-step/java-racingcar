package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockAlwaysMaxValueRandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;
    private final int numberOfCountToTry = 5;

    @BeforeEach
    void init() {
        racingCar = new RacingCar(new MockAlwaysMaxValueRandomUtil(), numberOfCountToTry);
    }

    @Test
    @DisplayName("RacingCar가 전진에 모두 성공한다면 진행상황의 길이와 numberOfCountToTry가 같아야 한다.")
    void testRacingCar_moveToTry() {
        for (int i = 0; i < numberOfCountToTry; i++) {
            racingCar.tryToMove();
        }
        StringBuilder stringBuilder = new StringBuilder();
        racingCar.printProcess(stringBuilder);

        assertThat(stringBuilder.toString().length()).isEqualTo(numberOfCountToTry);
    }
}
