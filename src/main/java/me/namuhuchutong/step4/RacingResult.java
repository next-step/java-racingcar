package me.namuhuchutong.step4;

import java.util.List;

public class RacingResult {

    private final List<Cars> values;

    private final List<String> winners;

    public RacingResult(List<Cars> values, List<String> winners) {
        this.values = values;
        this.winners = winners;
    }

    public int getTotalRaceCount() {
        return this.values.size();
    }

    public List<Cars> getValues() {
        return List.copyOf(values);
    }

    public List<String> getWinners() {
        return List.copyOf(winners);
    }
}
