package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차들 중 우승자가 포함되어 있는지 확인한다.")
    void carsTest_getWinnerNames() {
        List<Car> carList = List.of(
                new Car(new CarName("pobi"), new Position(4)),
                new Car(new CarName("honux"), new Position(5)),
                new Car(new CarName("zzuni"), new Position(5))
        );
        Cars cars = new Cars(carList);

        List<String> winners = cars.getWinnerNames().getNames();
        assertThat(winners).contains("honux", "zzuni");
    }
}
