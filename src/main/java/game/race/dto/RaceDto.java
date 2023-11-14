package game.race.dto;

import java.util.List;

public class RaceDto {

    private final int tryCnt;
    private final List<String> vehicleNames;

    public RaceDto(int tryCnt, List<String> vehicleNames) {
        this.tryCnt = tryCnt;
        this.vehicleNames = vehicleNames;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public List<String> getVehicleNames() {
        return vehicleNames;
    }

    public static RaceDto of(int tryCnt, List<String> names) {
        return new RaceDto(tryCnt, names);
    }
}
