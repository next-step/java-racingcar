package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;

public class RacingGameControllerTest {
    private static RacingGameController rgc;
    private static InputStream in;
    @BeforeAll
    static void initAll() {
        rgc = new RacingGameController();
    }

    @Test
    void setCarsName() {
        rgc.setCarsName("pobi,woni,jun");

        ArrayList<RacingCar> cars = rgc.getCars();

        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("woni");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("jun");
    }
}
