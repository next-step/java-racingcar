package me.namuhuchutong.step3;

import java.util.List;

public class RacingResult {

    private final List<Cars> carsList;

    public RacingResult(List<Cars> carsList) {
        this.carsList = carsList;
    }

    public List<Cars> getCarsList() {
        return List.copyOf(carsList);
    }

    public int getTotalRace() {
        return this.carsList.size();
    }
}
