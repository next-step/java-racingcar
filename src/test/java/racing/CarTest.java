package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.strategy.MoveStrategy;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void play() {
        MoveStrategy moveStrategy = () -> true;

        Car car1 = new Car();
        car1.play(moveStrategy);
        car1.play(moveStrategy);

        Car car2 = new Car();
        car2.play(moveStrategy);
        car2.play(moveStrategy);

        Car car3 = new Car();
        car3.play(moveStrategy);

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
        MoveStrategy moveStrategy = () -> true;

        Car car = new Car();
        for (int i = 0; i < moveCount; i++) {
            car.play(moveStrategy);
        }

        return car;
    }

}