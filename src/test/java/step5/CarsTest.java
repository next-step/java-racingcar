package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import step5.model.Car;
import step5.model.Cars;
import step5.model.RandomMoveStrategy;

public class CarsTest {

    @Test
    void cars() {
        Cars cars = new Cars(new String[]{"kim", "lee"});
    }

    @Test
    void getWinners() {
        Car kim = new Car("kim", 0, new RandomMoveStrategy());
        Car lee = new Car("lee", 2, new RandomMoveStrategy());
        Car park = new Car("park", 2, new RandomMoveStrategy());
        Cars cars = new Cars(Arrays.asList(kim, lee, park));
        Cars winners = cars.getWinners();
        assertAll(
            () -> assertEquals(2, winners.getCars().size()),
            () -> assertThat(winners.getCars().get(0)).isEqualTo(new Car("lee", 2, new RandomMoveStrategy())),
            () -> assertThat(winners.getCars().get(1)).isEqualTo(new Car("park", 2, new RandomMoveStrategy()))
        );
    }
}
