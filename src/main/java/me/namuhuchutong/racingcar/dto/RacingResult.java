package me.namuhuchutong.racingcar.dto;

import java.util.List;
import me.namuhuchutong.racingcar.domain.Cars;
import me.namuhuchutong.racingcar.domain.Winners;

public class RacingResult {

    private final List<Cars> values;

    private final Winners winners;

    public RacingResult(List<Cars> values, Winners winners) {
        this.values = values;
        this.winners = winners;
    }

    public int getTotalRaceCount() {
        return this.values.size();
    }

    public List<Cars> getValues() {
        return List.copyOf(values);
    }

    public List<String> getWinnersName() {
        return this.winners.getNames();
    }
}
