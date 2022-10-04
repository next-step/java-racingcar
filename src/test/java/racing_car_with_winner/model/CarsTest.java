package racing_car_with_winner.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 주어진이름을가지는차를만든다() {
        List<Car> cars = new CarFactory(new CarNameInput("1,2,3")).build();

        Assertions.assertThat(new Cars(cars).getCars()).hasSize(3);
    }
}
