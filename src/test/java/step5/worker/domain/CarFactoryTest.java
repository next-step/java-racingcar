package step5.worker.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.worker.domain.strategy.MovableStrategy;
import step5.worker.domain.strategy.RandomMovableStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {
    private final MovableStrategy movableStrategy = new RandomMovableStrategy();

    @DisplayName("'RacingCar' 다중 생성 테스트")
    @Test
    void createCars() {
        // given
        final List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        
        // when
        final List<Car> result = CarFactory.createCars(carNames, movableStrategy);

        // then
        assertThat(result.size()).isEqualTo(carNames.size());
    }
}