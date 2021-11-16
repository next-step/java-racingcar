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

    public Names findWinners() {
        Location bestRecord = findBestRecord();

        String text = cars.stream()
                .filter(car -> car.getLocation().equals(bestRecord))
                .map(n -> String.valueOf(n.getName().getName()))
                .collect(Collectors.joining(","));

        return Names.from(text);
    }

    private Location findBestRecord() {
        int bestRecord = cars.stream()
                .mapToInt(car -> car.getLocation().getLocation())
                .max().getAsInt();
        return new Location(bestRecord);
    }
}
