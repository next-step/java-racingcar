package step3.study.domain;

import step3.study.dto.RequestRacingDTO;
import step3.study.dto.ResponseRacingDTO;
import step3.study.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Drivers {
    private final List<Driver> drivers;

    public Drivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public static List<Driver> of(RequestRacingDTO requestRacingDTO) {
        String[] driverNames = requestRacingDTO.getDriverNames();

        return Arrays.stream(driverNames)
                .map(driverName -> new Driver(driverName, new Car()))
                .collect(Collectors.toList());
    }

    public ResponseRacingDTO moveCars(RandomGenerator randomGenerator) {
        for (Driver driver : drivers) {
            int randomNumber = randomGenerator.getRandomNumber();
            driver.moveCar(randomNumber);
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

    private int getMaxDistance() {
        return this.drivers
                .stream()
                .mapToInt(driver -> driver.getDistance().length())
                .max()
                .getAsInt();
    }
}
