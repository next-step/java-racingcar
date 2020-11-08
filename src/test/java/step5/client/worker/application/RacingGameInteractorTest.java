package step5.client.worker.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step5.client.worker.application.RacingGameInteractor.ErrorMessage.NOT_BE_NULL;

class RacingGameInteractorTest {

    @DisplayName("'condition'이 null 인 경우 'IllegalArgumentException'를 throw")
    @Test
    void constructor_throw_IllegalArgumentException_when_condition_is_null() {
        // when
        final Throwable thrown = catchThrowable(() -> {
            new RacingGameInteractor().interact(null);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_BE_NULL.getMessage());
    }
    
    @DisplayName("simulate")
    @ParameterizedTest
    @MethodSource("generateSampleForSimulateMethodTesting")
    void simulate(final String carNames, final String numberAttempts) {
        // given
        final RacingGameRequest request = RacingGameRequest.of(carNames, numberAttempts);
        final RacingGameInteractor simulator = new RacingGameInteractor();
        
        // when
        final RacingGameResponse result = simulator.interact(request);
        
        // then
        assertThat(result.getSnapshots().size()).isEqualTo(Integer.valueOf(numberAttempts));
    }

    static Stream<Arguments> generateSampleForSimulateMethodTesting() {
        return Stream.of(
                Arguments.of("a,b,c", "2"),
                Arguments.of("pobi,crong,honux", "3"),
                Arguments.of("pobi,crong,honux,hong", "4")
        );
    }

}