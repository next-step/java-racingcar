package me.namuhuchutong.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<Cars> carsList;

    public RacingResult() {
        this.carsList = new ArrayList<>();
    }

    public void addFinishedRacing(Cars cars) {
        this.carsList.add(cars);
    }

    public List<Cars> getCarsList() {
        return List.copyOf(carsList);
    }

    public int getTotalRace() {
        return this.carsList.size();
    }
}
