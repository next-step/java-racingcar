package racing_car_with_winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameInputTest {

    @Test
    void 자동차이름은_길이를제한한다() {
        String name = GameInput.getName();

        Assertions.assertThat(name).hasSizeLessThan(5);
    }
}
