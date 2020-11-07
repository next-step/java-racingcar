package racing.domain;

import java.util.ArrayList;
import java.util.List;
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

    public List<RaceMachine> getMachinesInLap(int lap) {
        return raceMachines.stream()
                .filter(raceMachine -> raceMachine.getLap() == lap)
                .collect(Collectors.toList());
    }

    public void each(Consumer<RaceMachine> consumer) {
        this.raceMachines.forEach(consumer);
    }

    public int getLastLap() {
        return raceMachines.stream()
                .map(RaceMachine::getLap)
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("참가한 자동차가 없습니다."));
    }

    public String getChampionNames() {
        return getMachinesInLap(getLastLap()).stream()
                .map(RaceMachine::getDriverName)
                .collect(Collectors.joining(", "));
    }
}
