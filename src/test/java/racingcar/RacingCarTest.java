package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;
    private RacingCar racingCar2;

    @Test
    void compareToRacingCar1Lose(){
        racingCar = new RacingCar("1", 2);
        racingCar2 = new RacingCar("1", 3);
        assertThat(racingCar.compareTo(racingCar2)).isEqualTo(-1);
    }

    @Test
    void compareToRacingCar1Win(){
        racingCar = new RacingCar("1", 3);
        racingCar2 = new RacingCar("1", 2);
        assertThat(racingCar.compareTo(racingCar2)).isEqualTo(1);
    }

    @Test
    void compareToDraw(){
        racingCar = new RacingCar("1", 2);
        racingCar2 = new RacingCar("1", 2);
        assertThat(racingCar.compareTo(racingCar2)).isEqualTo(0);
    }
}
