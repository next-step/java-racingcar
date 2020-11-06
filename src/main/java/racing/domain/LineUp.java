package racing.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class LineUp {
    private final List<RaceMachine> raceMachines = new ArrayList<>();

    public LineUp(List<RaceMachine> raceMachines) {
        this.raceMachines.addAll(raceMachines);
    }

    public void runRound() {
        raceMachines.forEach(RaceMachine::accelerate);
    }

    public List<RaceMachine> getMachinesInLap(int lap) {
        return raceMachines.stream()
                .filter(raceMachine -> raceMachine.getLap() == lap)
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> getLapMapStatus() {
        return raceMachines.stream()
                .collect(Collectors.toMap(RaceMachine::getId, RaceMachine::getLap));
    }
}
