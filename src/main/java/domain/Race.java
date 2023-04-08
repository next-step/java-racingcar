package domain;

public class Race {
    private final RaceInfo raceInfo;

    public Race(RaceInfo raceInfo) {
        this.raceInfo = raceInfo;
    }

    public RaceResult calculate() {
        CarNumber carNumber = raceInfo.getCarNumber();
        RaceNumber raceNumber = raceInfo.getRaceNumber();
        return new RaceResult();
    }
}
