package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.application.RandomMovableStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarFactoryTest {
    private final MovableStrategy movableStrategy = new RandomMovableStrategy();

    @DisplayName("'RacingCar' 다중 생성 테스트")
    @Test
    void createCars() {
        // given
        final List<String> nameOfCars = Arrays.asList("pobi", "crong", "honux");
        
        // when
        final List<RacingCar> result = RacingCarFactory.createCars(nameOfCars, movableStrategy);

        // then
        assertThat(result.size()).isEqualTo(nameOfCars.size());
    }
}