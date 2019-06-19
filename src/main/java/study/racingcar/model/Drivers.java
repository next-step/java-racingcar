package study.racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-19
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Drivers {
    private Set<Driver> drivers;

    public Drivers(Set<String> driverNames) {
        this.drivers = driverNames.stream()
                .map(Driver::new)
                .collect(Collectors.toSet());
    }

    public Drivers(List<Driver> drivers) {
        this.drivers = new HashSet<>(drivers);
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }
}
