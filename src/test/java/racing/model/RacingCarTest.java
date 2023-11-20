package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.strategy.ManualNumberGenerator;
import racing.model.strategy.NumberGeneratorStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    RacingCar car;

    @BeforeEach
    void init() {
        car = new RacingCar(0, "pobi");
    }

    @Test
    @DisplayName("random 값이 4이상 전진")
    void test1() throws Exception {
        NumberGeneratorStrategy strategy = new ManualNumberGenerator();
        int random = strategy.generateNumber(4);
        int start = 0;
        car.race(random);
        assertThat(car.getMoveCondition()).isEqualTo(start + 1);
    }

    @Test
    @DisplayName("random 값이 4미만 정지")
    void test2() throws Exception {
        NumberGeneratorStrategy strategy = new ManualNumberGenerator();
        int random = strategy.generateNumber(3);
        int start = 0;
        car.race(random);
        assertThat(car.getMoveCondition()).isEqualTo(start);
    }
}