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

    public List<String> getNames() {
        return drivers.getDriverList()
                .stream()
                .map(Driver::name)
                .collect(Collectors.toList());
    }

    public List<Integer> getPosition() {
        return drivers.getDriverList()
                .stream()
                .map(Driver::position)
                .collect(Collectors.toList());
    }
}
