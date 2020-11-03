package racing.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GrandPrix {
    private final int maxLaps;
    private final List<RaceMachine> raceMachines = new ArrayList<>();
    private int currentLap = 1;

    public GrandPrix(int numberOfMachines, int maxLaps) {
        this.maxLaps = maxLaps;
        for (int id = 0; id < numberOfMachines; id++) {
            raceMachines.add(new RaceMachine(id));
        }
    }

    public void checkLap() {
        if (currentLap >= maxLaps) {
            return;
        }
        currentLap++;
        raceMachines.forEach(RaceMachine::accelerate);
    }

    public List<RaceMachine> getMachinesInLap(int lap) {
        return raceMachines.stream()
                .filter(raceMachine -> raceMachine.getLap() == lap)
                .collect(Collectors.toList());
    }

    public void startRace() {
        do {
            checkLap();
        } while (currentLap < maxLaps);
    }
}
