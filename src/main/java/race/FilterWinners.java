package race;

import java.util.Collection;
import java.util.stream.Collectors;

public class FilterWinners {
    public Collection<Car> filter(Collection<Car> cars) {
        if(cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("cars must not be empty");
        }

        int maxLocation = cars.stream().mapToInt(Car::location).max().getAsInt();
        return cars.stream().filter((car -> car.location() == maxLocation)).collect(Collectors.toList());
    }
}
