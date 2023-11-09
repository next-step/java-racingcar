package game.race.dto;

public class RaceDto {

    private int vehicleCnt;

    private int tryCnt;

    public RaceDto(int vehicleCnt, int tryCnt) {
        this.vehicleCnt = vehicleCnt;
        this.tryCnt = tryCnt;
    }

    public static RaceDto of(int vehicleCnt, int tryCnt) {
        return new RaceDto(vehicleCnt, tryCnt);
    }

    public int getVehicleCnt() {
        return vehicleCnt;
    }

    public void setVehicleCnt(int vehicleCnt) {
        this.vehicleCnt = vehicleCnt;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setTryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }
}
