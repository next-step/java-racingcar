package step3.application.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.application.domain.model.OneMoveRecord;
import step3.application.generator.NumberPredicatedGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private RacingCars racingCars;
    private OneMoveRecord oneMoveRecord;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(
                List.of(
                        new Car(1),
                        new Car(2),
                        new Car(3),
                        new Car(4)

                ),
                new NumberPredicatedGenerator()
        );
    }

    @Test
    void moveCars() {
        OneMoveRecord result = racingCars.moveCars();
        assertThat(result.getCarLocation())
                .containsExactlyInAnyOrderElementsOf(List.of(0, 1, 0, 1));
    }
}