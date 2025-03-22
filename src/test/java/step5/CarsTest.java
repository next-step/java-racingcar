package step5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 모든_자동차_전진() {
        Cars cars = new Cars(List.of(
                new Car(new Position(0)),
                new Car(new Position(0)),
                new Car(new Position(0))
        ));

        cars.moveAll(() -> true);
        assertThat(cars).isEqualTo(new Cars(List.of(
                new Car(new Position(1)),
                new Car(new Position(1)),
                new Car(new Position(1))
        )));
    }
}
