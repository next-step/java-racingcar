package step3.study.dto;

import step3.study.domain.Driver;
import step3.study.domain.Drivers;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseRacingDTO {
    private final Drivers drivers;

    public ResponseRacingDTO(Drivers drivers) {
        this.drivers = drivers;
    }

    public Drivers getDrivers() {
        return drivers;
    }

    public List<String> getNameAndNowPosition(){
        return drivers.getDriverList()
                .stream()
                .map(Driver::getNameAndNowPosition)
                .collect(Collectors.toList());
    }
}
