package step3.study.dto;

import step3.study.domain.Drivers;

public class ResponseRacingDTO {
    private final Drivers drivers;

    public ResponseRacingDTO(Drivers drivers) {
        this.drivers = drivers;
    }

    public Drivers getDrivers() {
        return drivers;
    }
}
