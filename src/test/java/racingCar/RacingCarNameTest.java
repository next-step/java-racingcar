package racingCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.utils.Utils;

public class RacingCarNameTest {

    @Test
    @DisplayName("너무 긴 이름은 에러")
    void too_long_name() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RacingCarName racingCarName = new RacingCarName("imWinner");
        });
    }

    @Test
    @DisplayName("이름이 비어있으면 에러")
    void null_name() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RacingCarName racingCarName = new RacingCarName("");
        });
    }
}
