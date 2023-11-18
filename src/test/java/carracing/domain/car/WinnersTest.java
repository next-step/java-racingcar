package carracing.domain.car;

import carracing.domain.game.MaxMoving;
import carracing.domain.game.WinnerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    private WinnerStrategy winnerStrategy;
    private CarName carName;

    @BeforeEach
    void setUp() {
        this.winnerStrategy = new MaxMoving();
        this.carName = new CarName("abc");
    }

    @Test
    void isSame_twoWinnersWithMaxMoving_true() {
        Car car1 = new Car(10, carName);
        Car car2 = new Car(10, carName);
        Car car3 = new Car(8, carName);
        Cars cars = new Cars(List.of(car1, car2, car3));
        Cars winCars = new Cars(List.of(car1, car2));

        Winners winners = winnerStrategy.winners(cars);
        Winners expected = new Winners(winCars);

        assertThat(expected).isEqualTo(winners);
    }
}
