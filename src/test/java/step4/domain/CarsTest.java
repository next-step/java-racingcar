package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.strategy.MovableStrategy;
import step4.strategy.TestMovableStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;
    private MovableStrategy strategy;

    @BeforeEach
    public void setUp() {
        this.cars = Cars.from(Arrays.asList("kwon", "soon", "ho"));
        this.strategy = new TestMovableStrategy();
    }

    @Test
    public void move() {
        cars.move(strategy);
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    public void getWinners() {
        // given
        cars.move(strategy);
        // when
        List<String> winners = cars.getWinnerNames();
        // then
        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners.get(0)).isEqualTo("kwon");
        assertThat(winners.get(1)).isEqualTo("soon");
        assertThat(winners.get(2)).isEqualTo("ho");
    }
}