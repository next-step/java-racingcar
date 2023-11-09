package game.race.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceDto {

    private int tryCnt;
    private int vehicleCnt;
    private List<String> vehicleNames;

    public RaceDto(int tryCnt,
                   int vehicleCnt,
                   List<String> vehicleNames) {
        this.tryCnt = tryCnt;
        this.vehicleCnt = vehicleCnt;
        this.vehicleNames = vehicleNames;
    }

    public static RaceDto of(String vehicleName, int tryCnt) {
        List<String> names = Arrays.stream(vehicleName.split(","))
                                   .collect(Collectors.toList());
        return new RaceDto(tryCnt, names.size(), names);
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setTryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public int getVehicleCnt() {
        return vehicleCnt;
    }

    public void setVehicleCnt(int vehicleCnt) {
        this.vehicleCnt = vehicleCnt;
    }

    public List<String> getVehicleNames() {
        return vehicleNames;
    }

    public void setVehicleNames(List<String> vehicleNames) {
        this.vehicleNames = vehicleNames;
    }
}
