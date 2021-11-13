package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private static final Integer START_INDEX = 0;

    private List<Car> cars;

    public static Cars from(Names names) {
        return Cars.of(names, Location.START_LOCATION);
    }

    public static Cars of(Names names, Integer location) {

        List<Car> entryCars = names.getNames()
                                    .stream()
                                    .map(name -> new Car(name, location))
                                    .collect(Collectors.toList());
        return new Cars(entryCars);
    }

    private Cars (List<Car> entryCars) {
       this.cars = entryCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void roundRacing(StateGenerator stateGenerator) {
        for (Car car : cars) {
            car.move(stateGenerator);
        }
    }

    public Location inFormFirstRecord() {
        Car car = cars.get(0);
        Location location = car.getLocation();
        for (int i = 1; i < cars.size(); i++) {
            location = location.compareToLocation(cars.get(i).getLocation());
        }
        return location;
    }

    public Names inFormWinners(Location firstRecord) {
        List<Name> names = new ArrayList<>();
        for (Car car : cars) {
            compareToRecord(names, car, firstRecord);
        }
        return new Names(names);
    }

    private void compareToRecord(List names, Car car, Location firstRecord) {
        if (firstRecord.equals(car.getLocation())) {
            names.add(car.getName());
        }
    }
}
