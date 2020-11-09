package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.resolver.SimpleAccelerateResolver;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GranPrixTest {

    GrandPrix grandPrix;

    @BeforeEach
    private void makeTestGrandPrix() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 3; id++) {
            raceMachines.add(new RaceMachine("Lewis", new SimpleAccelerateResolver(true)));
        }
        grandPrix = new GrandPrix(new LineUp(raceMachines), 5);
    }

    @Test
    void testMakeUp() {
        assertThat(grandPrix.getLineUp()).isNotNull();
        assertThat(grandPrix.getMaxRounds()).isEqualTo(5);
    }

    @Test
    void testRunRound() {
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(1);
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(2);
    }

    @Test
    void testRunRoundOverMaxRound() {
        while (grandPrix.getCurrentRound() < grandPrix.getMaxRounds()) {
            grandPrix.runRound();
        }
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }

    @Test
    void testRunFullRace() {
        while (grandPrix.getCurrentRound() < grandPrix.getMaxRounds()) {
            grandPrix.runRound();
        }
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }
}
