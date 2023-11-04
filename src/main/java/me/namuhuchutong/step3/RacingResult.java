package me.namuhuchutong.step3;

import java.util.List;

public class RacingResult {

    private List<Cars> carsList;

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
