package step3.study.dto;

import step3.study.domain.Round;

import java.util.List;

public class RequestRacingDTO {
    private final List<String> driverNames;
    private final Round round;

    public RequestRacingDTO(List<String> driverNames, Round round) {
        this.driverNames = driverNames;
        this.round = round;
    }

    public List<String> getDriverNames() {
        return driverNames;
    }

    public Round getRound() {
        return round;
    }
}
