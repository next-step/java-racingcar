package racingcar.domains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.strategies.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private Cars moveResult;

    @BeforeEach
    void init() {
        cars = new Cars();
        cars.add(new Car("blue"));
        cars.add(new Car("pink"));
        cars.add(new Car("black"));

        moveResult = new Cars();
    }


    @Test
    void 자동차들_전진() {
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        };

        Cars result = cars.move(moveStrategy);

        moveResult.add(new Car("blue", 1));
        moveResult.add(new Car("pink", 1));
        moveResult.add(new Car("black", 1));

        assertThat(result).isEqualTo(moveResult);
    }

    @Test
    void 자동차들_멈춤() {
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        };

        Cars result = cars.move(moveStrategy);

        moveResult.add(new Car("blue", 0));
        moveResult.add(new Car("pink", 0));
        moveResult.add(new Car("black", 0));

        assertThat(result).isEqualTo(moveResult);
    }

}