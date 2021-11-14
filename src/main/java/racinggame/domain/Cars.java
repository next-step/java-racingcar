package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

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

    private Location inFormFirstRecord() {
        Car car = cars.get(0);
        Location location = car.getLocation();
        for (int i = 1; i < cars.size(); i++) {
            location = location.compareToLocation(cars.get(i).getLocation());
        }
        return location;
    }

    public Names inFormWinners() {
        StringBuilder names = new StringBuilder();
        Location firstRecord = this.inFormFirstRecord();
        for (Car car : cars) {
            compareToRecord(names, car, firstRecord);
        }
        return Names.from(names.toString());
    }

    private void compareToRecord(StringBuilder names, Car car, Location firstRecord) {
        if (firstRecord.equals(car.getLocation())) {
            names.append(car.getName().getName());
            names.append(",");
        }
    }
}
