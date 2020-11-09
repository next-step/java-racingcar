package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.RaceMachine;
import racing.resolver.SimpleAccelerateResolver;

import static org.assertj.core.api.Assertions.assertThat;

class RaceMachineServiceTest {
    private final RaceMachineService raceMachineService = new RaceMachineService();
    RaceMachine raceMachine;

    @BeforeEach
    void makeTestRaceMachine() {
        raceMachine = raceMachineService.create(new RaceMachine("Lewis", new SimpleAccelerateResolver(true)));
    }

    @Test
    void testCreateRaceMachine() {
        assertThat(raceMachine.getId()).isNotNull();
    }

    @Test
    void testGetRaceMachine() {
        RaceMachine result = raceMachineService.get(raceMachine.getId());
        assertThat(result.getDriverName()).isEqualTo(raceMachine.getDriverName());
    }
}
