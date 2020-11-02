package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step3.application.RacingCarSimulator.ErrorMessage.NOT_BE_NULL;

class RacingCarSimulatorTest {

    @DisplayName("'condition'이 null 인 경우 'IllegalArgumentException'를 throw")
    @Test
    void constructor_throw_IllegalArgumentException_when_condition_is_null() {
        // when
        final Throwable thrown = catchThrowable(() -> {
            new RacingCarSimulator(null);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_BE_NULL.getMessage());
    }
    
    @DisplayName("simulate")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "3:5", "100:300"}, delimiter = ':')
    void simulate(final int numberOfCar, final int numberOfAttempts) {
        // given
        final SimulationCondition condition = new SimulationCondition(numberOfCar, numberOfAttempts);
        final RacingCarSimulator simulator = new RacingCarSimulator(condition);
        
        // when
        final SimulationResult result = simulator.simulate();
        
        // then
        assertThat(result.getRacingCars().size()).isEqualTo(numberOfCar);
        assertThat(result.getSnapshots().size()).isEqualTo(numberOfAttempts);
    }
    

}