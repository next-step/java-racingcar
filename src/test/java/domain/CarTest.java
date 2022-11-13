package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import strategy.MoveStrategy;

public class CarTest {

    @Test
    void alwaysMove() {
        MoveStrategy alwaysMoveStrategy = () -> true;
        Car car = new Car(new CarName("gglee"), new Position(1), alwaysMoveStrategy);
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(3));
    }

    @Test
    void alwaysStop() {
        MoveStrategy alwaysStopStrategy = () -> false;
        Car car = new Car(new CarName("gglee"), new Position(0), alwaysStopStrategy);
        car.move();
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}
