package game.race.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static RaceDto of(String vehicleName, int tryCnt) {
        List<String> names = Arrays.stream(vehicleName.split(","))
                                   .collect(Collectors.toList());
        return new RaceDto(tryCnt, names);
    }
}
