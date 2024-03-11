package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.strategy.MoveStrategy;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final MoveStrategy alwaysTrueStrategy = () -> true;

    @Test
    void play() {
        Car car1 = new Car("test");
        car1.play(alwaysTrueStrategy);
        car1.play(alwaysTrueStrategy);

        Car car2 = new Car("nimoh");
        car2.play(alwaysTrueStrategy);
        car2.play(alwaysTrueStrategy);

        Car car3 = new Car("pobi");
        car3.play(alwaysTrueStrategy);

        assertThat(car1).isEqualTo(car2);
        assertThat(car1).isNotEqualTo(car3);

    }

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----", "5:-----"}, delimiter = ':')
    void carPosition(int input, String dash) {
        Car car = getMovedCar(input);

        assertThat(car.carPosition()).isEqualTo(dash);
    }

    private Car getMovedCar(int moveCount) {
        Car car = new Car("test");
        for (int i = 0; i < moveCount; i++) {
            car.play(alwaysTrueStrategy);
        }

        return car;
    }

}