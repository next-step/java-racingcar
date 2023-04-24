import model.AlwaysMoveStrategy;
import model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void carMoves() {
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var car = new Car("name");
        for (int i = 0; i < steps; ++i) {
            car.moveWithStrategy(strategy);
        }

        assertThat(car.getPosition()).isEqualTo(steps);
    }

    @Test
    public void carHasName() {
        var name = "teddy";
        var car = new Car("teddy");

        var result = car.getName();

        assertThat(result).isEqualTo(name);
    }
}
