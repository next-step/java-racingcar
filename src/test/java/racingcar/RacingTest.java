package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest extends IOTest{

    @Test
    @DisplayName("Racing")
    public void race() {
        CarGroup carGroup = new CarGroup();
        Racing racing = new Racing(carGroup);

        racing.race();
    }
}
