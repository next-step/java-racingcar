package me.namuhuchutong.step3;

import java.util.List;

public class RacingResult {

    private final List<Cars> values;

    public RacingResult(List<Cars> values) {
        this.values = values;
    }

    public List<Cars> getValues() {
        return List.copyOf(values);
    }

    public int getTotalRace() {
        return this.values.size();
    }
}
