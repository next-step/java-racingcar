package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GranPrixTest {
    @Test
    void testMakeUp(){
        GrandPrix grandPrix = new GrandPrix(3, 5);
        assertThat(grandPrix.getRaceMachines()).size().isEqualTo(3);
        assertThat(grandPrix.getMaxLaps()).isEqualTo(5);
    }

    @Test
    void testCheckLap(){
        GrandPrix grandPrix = new GrandPrix(3, 5);
        grandPrix.checkLap();
        assertThat(grandPrix.getCurrentLap()).isEqualTo(2);
        grandPrix.checkLap();
        assertThat(grandPrix.getCurrentLap()).isEqualTo(3);
    }

    @Test
    void testGetMachinesInLap(){
        GrandPrix grandPrix = new GrandPrix(3, 5);
        grandPrix.checkLap();
        List<RaceMachine> machines = grandPrix.getMachinesInLap(3);
        assertThat(machines).size().isZero();
    }

   @Test
    void testStartRace(){
       GrandPrix grandPrix = new GrandPrix(3, 5);
       grandPrix.startRace();
       assertThat(grandPrix.getCurrentLap()).isEqualTo(grandPrix.getMaxLaps());
   }
}
