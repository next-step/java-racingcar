package racing;

import org.junit.jupiter.api.Test;
import racing.strategy.MoveStrategy;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final MoveStrategy alwaysTrueStrategy = () -> true;

    @Test
    void getPosition() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getName() {
        String name = "test";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

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

}