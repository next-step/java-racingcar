package step5.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 우승자_찾기() {
        Cars cars = new Cars(List.of(
                new Car(new Position(0)),
                new Car(new Position(1)),
                new Car(new Position(1))
        ));

        assertThat(cars.findWinners()).containsExactly(
                new Car(new Position(1)),
                new Car(new Position(1))
        );
    }
}
