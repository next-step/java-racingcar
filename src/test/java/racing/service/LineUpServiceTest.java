package racing.service;

import org.junit.jupiter.api.Test;
import racing.domain.LineUp;
import racing.resolver.SimpleAccelerateResolver;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineUpServiceTest {
    private final RaceMachineService raceMachineService = new RaceMachineService();
    private final LineUpService lineUpService = new LineUpService(raceMachineService, new SimpleAccelerateResolver(true));

    @Test
    void testAutoBuildLineUp() {
        LineUp lineUp = lineUpService.createMachines(Arrays.asList("Lewis Hamilton", "Valtteri Bottas", "Max Verstappen", "Daniel Ricciardo"));
        assertThat(lineUp).isNotNull();

        lineUp.each(raceMachine -> {
            assertThat(raceMachine.getAccelerateResolver()).isNotNull();
        });
    }
}
