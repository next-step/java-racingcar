package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    void playerCar() {
        assertThat(Racing.playerCar("chloe,chloe")).containsExactly("chloe", "chloe");
    }

    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> Racing.playerCar("chloe,chloeJ")).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void winner() {
        List<Car> cars = new ArrayList<Car>();

        cars.add(new Car("chloe",4));
        cars.add(new Car("tt",5));
        cars.add(new Car("ss",5));

        assertThat(Racing.printWinner(cars)).containsExactly("tt","ss");
    }

    @Test
    void movedTest() {
        Car aCar = new Car("name");
        Racing.moved(6, aCar);
        assertThat(aCar.getMovingRange()).isEqualTo(1);
    }
}
