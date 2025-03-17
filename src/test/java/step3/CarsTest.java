package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {


    @Test
    void 정해진_갯수의_차를_가진다() {
        MovingStrategy movingStrategy = () -> true;
        Cars cars = new Cars(5, movingStrategy);

        assertThat(cars.getCars().size()).isEqualTo(5);
    }

    @Test
    void 여러대의_차를_모두_같은_전략으로_이동시킨다() {
        MovingStrategy movingStrategy = () -> true;
        Cars cars = new Cars(5, movingStrategy);

        cars.moveAll();

        assertThat(cars.getCars())
                .allMatch(car -> car.getPosition() == 1);
    }
}