package racing.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GrandPrix {
    private int id;
    private final int maxRounds;
    private final List<RaceMachine> raceMachines = new ArrayList<>();
    private int currentRound = 1;

    public GrandPrix(int numberOfMachines, int maxRounds) {
        this.maxRounds = maxRounds;
        for (int machineId = 0; machineId < numberOfMachines; machineId++) {
            raceMachines.add(new RaceMachine(machineId));
        }
    }

    public void runRound() {
        if (currentRound >= maxRounds) {
            return;
        }
        currentRound++;
        raceMachines.forEach(RaceMachine::accelerate);
    }

    public List<RaceMachine> getMachinesInLap(int lap) {
        return raceMachines.stream()
                .filter(raceMachine -> raceMachine.getLap() == lap)
                .collect(Collectors.toList());
    }

    public void runFullRace() {
        do {
            runRound();
        } while (currentRound < maxRounds);
    }

    public void setId(int id) {
        this.id = id;
    }
}
