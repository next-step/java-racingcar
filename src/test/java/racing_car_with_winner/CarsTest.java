package racing_car_with_winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 주어진이름을가지는차를만든다() {
        String[] names = new String[] {"a", "b", "c"};

        Assertions.assertThat(new Cars(names).getCars()).hasSize(3);
    }
}
