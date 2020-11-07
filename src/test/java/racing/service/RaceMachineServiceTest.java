package racing.service;

import org.junit.jupiter.api.Test;
import racing.domain.RaceMachine;
import racing.resolver.SimpleAccelerateResolver;

import static org.assertj.core.api.Assertions.assertThat;

class RaceMachineServiceTest {
    private final RaceMachineService raceMachineService = new RaceMachineService();

    @Test
    void testCreateRaceMachine() {
        RaceMachine raceMachine = raceMachineService.create(new RaceMachine("Lewis Hamilton", new SimpleAccelerateResolver(true)));
        assertThat(raceMachine.getId()).isNotNull();
    }

    @Test
    void testGetRaceMachine() {
        RaceMachine raceMachine = raceMachineService.create(new RaceMachine("Lewis Hamilton", new SimpleAccelerateResolver(true)));
        RaceMachine result = raceMachineService.get(raceMachine.getId());
        assertThat(result.getDriverName()).isEqualTo(raceMachine.getDriverName());
    }
}
