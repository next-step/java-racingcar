import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private final RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("0에서 9 사이 random 값을 생성한다.")
    public void test4() {
        assertThat(racingCar.createRandom()).isBetween(0, 9);
    }


}
