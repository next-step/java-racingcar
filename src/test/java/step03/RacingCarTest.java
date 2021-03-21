package step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setRacingCar() {
        racingCar = new RacingCar("test");
    }

    @Test
    @DisplayName("무조건 전진")
    void tryToMove() {

        // when
        racingCar.tryToMove(() -> true);



    }
}
