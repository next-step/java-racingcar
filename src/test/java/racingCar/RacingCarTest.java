package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    private RacingCarGame racingCar = new RacingCarGame();
    @Test
    @DisplayName("입력 유효성 검증")
    void randomNumber(){
        racingCar.play();
    }
}
