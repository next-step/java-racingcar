package domain;

import movingStrategy.AlwaysMove;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {
  
    public static final String NAME = "test";

    @DisplayName("차량 진행 테스트")
    @Test
    void tryToGo() {
        RacingCar racingCar = new RacingCar(NAME);
        RacingCar actual = racingCar.move(new AlwaysMove());
        RacingCar expected = new RacingCar(NAME, new Position(1));
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}