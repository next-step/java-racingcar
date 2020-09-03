package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;
import static racingcar.domain.car.WinnerCars.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCarsTest {

    @Test
    void winnersNamesTest() {
        WinnerCars winnerCars = new WinnerCars(Arrays.asList(new Car("pobi"), new Car("crong")));
        assertThat(winnerCars.getWinnersNames()).isEqualTo("pobi, crong");
    }
}
