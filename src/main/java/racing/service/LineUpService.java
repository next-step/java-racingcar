package racing.service;

import racing.domain.LineUp;
import racing.domain.RaceMachine;
import racing.resolver.RandomAccelerateResolver;

import java.util.ArrayList;
import java.util.List;

public class LineUpService {
    public LineUp createRandomAccelerateMachines(int numberOfMachines) {
        List<RaceMachine> raceMachines = new ArrayList<>();
        for (int machineId = 0; machineId < numberOfMachines; machineId++) {
            raceMachines.add(new RaceMachine(machineId, new RandomAccelerateResolver(10, 4)));
        }
        return new LineUp(raceMachines);
    }
}
