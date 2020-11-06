package racing.view.to;

import lombok.Getter;

@Getter
public class RacingInputTO {
    private final int maxMachines;
    private final int maxRounds;

    public RacingInputTO(int maxMachines, int maxRounds) {
        this.maxMachines = maxMachines;
        this.maxRounds = maxRounds;
    }
}

