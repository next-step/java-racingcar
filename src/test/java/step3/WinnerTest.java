package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

    private List<Car> cars = new ArrayList<>();
    Winner winner = new Winner();

    @BeforeEach
    void setCars(){
        cars.add(new Car("car1", 1));
        cars.add(new Car("car2", 5));
        cars.add(new Car("car3", 5));
    }

    @Test
    void 최대_이동수() {
        winner.addWinner(cars);
        assertThat(winner.getMax()).isEqualTo(5);
    }

}
