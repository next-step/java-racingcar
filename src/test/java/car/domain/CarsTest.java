package car.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        String carNames = "씽씽카,쏘카,그린카";
        cars = Cars.of(carNames);
    }

    @Test
    void 일급객체가_관리하는_자동차의_크기를_구한다() {
        assertThat(cars.getParticipants()).hasSize(3);
    }
}
