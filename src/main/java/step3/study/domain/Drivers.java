package step3.study.domain;

import step3.study.dto.RequestRacingDTO;
import step3.study.dto.ResponseRacingDTO;
import step3.study.util.NumberGenerator;
import step3.study.util.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Drivers {
    private final List<Driver> drivers;

    public Drivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public static List<Driver> of(RequestRacingDTO requestRacingDTO) {
        List<String> driverNames = requestRacingDTO.getDriverNames();

        return driverNames.stream()
                .map(driverName -> new Driver(driverName, new Car()))
                .collect(Collectors.toList());
    }

    public ResponseRacingDTO moveCars(NumberGenerator numberGenerator) {
        for (Driver driver : drivers) {
            int number = numberGenerator.createNumber();
            driver.moveCar(number);
        }
        return new ResponseRacingDTO(this);
    }

    public List<Driver> getDriverList() {
        return drivers;
    }

    public List<String> getWinnerNames() {
        int maxDistance = getMaxDistance();
        return this.drivers
                .stream()
                .filter(driver -> driver.getDistance().length() == maxDistance)
                .map(Driver::getName)
                .collect(Collectors.toList());
    }

    public int getMaxDistance() {
        return this.drivers
                .stream()
                .mapToInt(driver -> driver.getDistance().length())
                .max()
                .getAsInt();
    }
}
