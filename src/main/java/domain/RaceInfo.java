package domain;

public class RaceInfo {
    private final CarNumber carNumber;
    private final RaceNumber raceNumber;
    public RaceInfo(CarNumber carNumber, RaceNumber raceNumber) {
        this.carNumber = carNumber;
        this.raceNumber = raceNumber;
    }

    public CarNumber getCarNumber() {
        return carNumber;
    }

    public RaceNumber getRaceNumber() {
        return raceNumber;
    }
}
