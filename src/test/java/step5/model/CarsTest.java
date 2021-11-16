package step5.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import step5.view.CarDTO;

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
        List<CarDTO> winners = cars.getWinners().getCars();
        assertAll(
            () -> assertEquals(2, winners.size()),
            () -> assertEquals("lee", winners.get(0).getCarName()),
            () -> assertEquals(2, winners.get(0).getPosition()),
            () -> assertEquals("park", winners.get(1).getCarName()),
            () -> assertEquals(2, winners.get(1).getPosition())
        );
    }
}
