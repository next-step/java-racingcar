package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LineUp {
    private final List<RaceMachine> raceMachines = new ArrayList<>();

    public LineUp(List<RaceMachine> raceMachines) {
        this.raceMachines.addAll(raceMachines);
    }

    public void runRound() {
        raceMachines.forEach(RaceMachine::accelerate);
    }

    public Map<Integer, Integer> getLapMapStatus() {
        return raceMachines.stream()
                .collect(Collectors.toMap(RaceMachine::getId, RaceMachine::getLap));
    }

    public void each(Consumer<RaceMachine> consumer) {
        this.raceMachines.forEach(consumer);
    }
}
