package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void findWinnerTest() {
        Car pobi = new Car("pobi");
        pobi.forward(() -> true);
        pobi.forward(() -> true);

        Car crong = new Car("crong");
        crong.forward(() -> true);
        crong.forward(() -> true);

        Car honux = new Car("honux");
        honux.forward(() -> true);

        List<Car> cars = List.of(pobi, crong, honux);
        List<Car> winner = new Cars(cars).findWinner();

        assertThat(winner).contains(pobi, crong);
    }
}
