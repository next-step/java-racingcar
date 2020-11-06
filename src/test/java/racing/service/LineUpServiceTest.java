package racing.service;

import org.junit.jupiter.api.Test;
import racing.domain.LineUp;

import static org.assertj.core.api.Assertions.assertThat;

public class LineUpServiceTest {
    private final LineUpService lineUpService = new LineUpService();

    @Test
    void testAutoBuildLineUp() {
        LineUp lineUp = lineUpService.createRandomAccelerateMachines(10);
        assertThat(lineUp).isNotNull();
        assertThat(lineUp.getRaceMachines()).isNotEmpty();
        assertThat(lineUp.getRaceMachines()).allSatisfy(raceMachine -> {
            assertThat(raceMachine.getId()).isNotNull();
        });
    }
}
