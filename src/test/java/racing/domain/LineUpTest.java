package racing.domain;

import org.junit.jupiter.api.Test;
import racing.resolver.SupplierAccelerateResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LineUpTest {

    @Test
    void testGetMachinesInLap() {

        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 5; id++) {
            int finalId = id;
            RaceMachine raceMachine = new RaceMachine(id, new SupplierAccelerateResolver(() -> finalId % 2 == 1));
            raceMachines.add(raceMachine);
        }

        LineUp lineUp = new LineUp(raceMachines);
        lineUp.runRound();
        List<RaceMachine> machinesInLap2 = lineUp.getMachinesInLap(2);
        assertThat(machinesInLap2).size().isEqualTo(2);
        List<RaceMachine> machinesInLap3 = lineUp.getMachinesInLap(3);
        assertThat(machinesInLap3).size().isZero();
    }

    @Test
    void testGetStatus() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int id = 0; id < 5; id++) {
            int finalId = id;
            RaceMachine raceMachine = new RaceMachine(id, new SupplierAccelerateResolver(() -> finalId % 2 == 1));
            raceMachines.add(raceMachine);
        }

        LineUp lineUp = new LineUp(raceMachines);
        lineUp.runRound();

        Map<Integer, Integer> lapMap = lineUp.getLapMapStatus();
        assertThat(lapMap).allSatisfy((machineId, lap) -> {
            assertThat(lap).isEqualTo(machineId % 2 == 1 ? 2 : 1);
        });
    }
}
