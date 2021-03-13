package step3.study.dto;

public class RequestRacingDTO {
    private final String[] driverNames;
    private final int tryCount;

    public RequestRacingDTO(String[] driverNames, int tryCount) {
        this.driverNames = driverNames;
        this.tryCount = tryCount;
    }

    public String[] getDriverNames() {
        return driverNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
