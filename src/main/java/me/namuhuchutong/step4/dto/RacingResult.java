package me.namuhuchutong.step4.dto;

import java.util.List;
import me.namuhuchutong.step4.domain.Cars;

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
