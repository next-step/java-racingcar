package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GranPrixTest {
    @Test
    void testMakeUp(){
        GrandPrix grandPrix = new GrandPrix(3, 5);
        assertThat(grandPrix.getRaceMachines()).size().isEqualTo(3);
        assertThat(grandPrix.getMaxRounds()).isEqualTo(5);
    }

    @Test
    void testRunRound() {
        GrandPrix grandPrix = new GrandPrix(3, 5);
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(2);
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(3);
    }

    @Test
    void testRunRoundOverMaxRound() {
        GrandPrix grandPrix = new GrandPrix(3, 5);
        grandPrix.runFullRace();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
        grandPrix.runRound();
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }

    @Test
    void testGetMachinesInLap() {
        GrandPrix grandPrix = new GrandPrix(3, 5);
        grandPrix.runRound();
        List<RaceMachine> machines = grandPrix.getMachinesInLap(3);
        assertThat(machines).size().isZero();
    }

    @Test
    void testRunFullRace(){
       GrandPrix grandPrix = new GrandPrix(3, 5);
       grandPrix.runFullRace();
       assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
   }
}
