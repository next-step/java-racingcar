package me.namuhuchutong.step4;

import java.util.List;

public class RacingResult {

    private final List<Cars> values;

    public RacingResult(List<Cars> values) {
        this.values = values;
    }

    public int getTotalRaceCount() {
        return this.values.size();
    }
}
