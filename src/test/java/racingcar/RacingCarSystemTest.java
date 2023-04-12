package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class RacingCarSystemTest {

    @Test
    @DisplayName("자동차 차량 수 입력")
    void numberOfCar()
    {
        int numberOfCar = 3;

        RacingCarSystem system = new RacingCarSystem();
        system.registerCar(3);

        assertThat(system.getRegisterNumberOfCar()).isEqualTo(numberOfCar);
    }
    
}
