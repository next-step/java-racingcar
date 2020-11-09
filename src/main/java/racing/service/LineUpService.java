package racing.service;

import lombok.AllArgsConstructor;
import racing.domain.LineUp;
import racing.domain.RaceMachine;
import racing.resolver.AccelerateResolver;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LineUpService {
    private final RaceMachineService raceMachineService;
    private final AccelerateResolver accelerateResolver;

    public LineUp createMachines(List<String> drivers) {
        List<RaceMachine> raceMachines = drivers.stream()
                .map(driverName -> raceMachineService.create(new RaceMachine(driverName, accelerateResolver)))
                .collect(Collectors.toList());

        return new LineUp(raceMachines);
    }
}
