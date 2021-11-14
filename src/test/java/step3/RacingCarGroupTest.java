package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.manager.RacingManager;
import step3.manager.RandomManager;

class RacingCarGroupTest {

    private static RacingCarGroup CAR_GROUP;
    private final static RacingManager MANAGER = new RandomManager();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    @DisplayName("갯수를 인자로 전달하면 갯수만큼 자동차가 생성된다.")
    public void carRunOrStop(int input) {
        CAR_GROUP = new RacingCarGroup(new Count(input));

        Assertions.assertThat(CAR_GROUP.carsCount()).isEqualTo(new Count(input));
    }
}