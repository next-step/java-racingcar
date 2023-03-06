import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.RacingCar;

public class RacingCarTest {
    RacingCar racingcar;

    @BeforeEach
    void setUp(){
        racingcar = new RacingCar();
    }

    @Test
    void racingCar() {
        racingcar.racingCar();
    }
}