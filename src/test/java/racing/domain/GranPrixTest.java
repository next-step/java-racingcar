package racing.domain;

import org.junit.jupiter.api.Test;
import racing.resolver.SimpleAccelerateResolver;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GranPrixTest {
    @Test
    void testMakeUp() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 5; id++) {
            raceMachines.add(new RaceMachine(id, new SimpleAccelerateResolver(true)));
        }

        LineUp lineUp = new LineUp(raceMachines);
        GrandPrix grandPrix = new GrandPrix(lineUp, 5);
        assertThat(grandPrix.getLineUp()).isNotNull();
        assertThat(grandPrix.getMaxRounds()).isEqualTo(5);
    }

    @Test
    void testRunRound() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 3; id++) {
            raceMachines.add(new RaceMachine(id, new SimpleAccelerateResolver(true)));
        }

        LineUp lineUp = new LineUp(raceMachines);
        GrandPrix grandPrix = new GrandPrix(lineUp, 5);
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(2);
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(3);
    }

    @Test
    void testRunRoundOverMaxRound() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 3; id++) {
            raceMachines.add(new RaceMachine(id, new SimpleAccelerateResolver(true)));
        }

        LineUp lineUp = new LineUp(raceMachines);
        GrandPrix grandPrix = new GrandPrix(lineUp, 5);
        grandPrix.runFullRace();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }



    @Test
    void testRunFullRace() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 3; id++) {
            raceMachines.add(new RaceMachine(id, new SimpleAccelerateResolver(true)));
        }

        LineUp lineUp = new LineUp(raceMachines);
        GrandPrix grandPrix = new GrandPrix(lineUp, 5);
        grandPrix.runFullRace();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }
}
