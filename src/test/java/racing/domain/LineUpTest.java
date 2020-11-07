package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.resolver.SupplierAccelerateResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LineUpTest {

    LineUp lineUp;

    @BeforeEach
    private void makeLineUp() {
        List<RaceMachine> raceMachines = new ArrayList<>();
        List<String> driverNames = Arrays.asList("Lewis Hamilton", "Valtteri Bottas", "Max Verstappen", "Daniel Ricciardo", "Sebastian Vettel");
        IntStream.range(0, driverNames.size()).forEach(id -> {
            String driverName = driverNames.get(id);
            RaceMachine raceMachine = new RaceMachine(driverName, new SupplierAccelerateResolver(() -> driverName.length() % 2 == 1));
            raceMachine.setId(id);
            raceMachines.add(raceMachine);
        });
        lineUp = new LineUp(raceMachines);
        lineUp.runRound();
    }

    @Test
    void testGetStatus() {
        lineUp.each(raceMachine -> {
            assertThat(raceMachine.getLap()).isEqualTo(raceMachine.getDriverName().length() % 2 == 1 ? 2 : 1);
        });
    }
}
