package racing.service;

import racing.domain.LineUp;
import racing.domain.RaceMachine;
import racing.resolver.RandomAccelerateResolver;

import java.util.ArrayList;
import java.util.List;

public class LineUpService {
    public LineUp createRandomAccelerateMachines(List<String> drivers) {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int machineId = 0; machineId < drivers.size(); machineId++) {
            raceMachines.add(new RaceMachine(machineId, new RandomAccelerateResolver(10, 4)));
        }
        return new LineUp(raceMachines);
    }
}
