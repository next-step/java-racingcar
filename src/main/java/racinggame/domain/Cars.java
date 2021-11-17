package racinggame.domain;

import racinggame.dto.RoundLog;
import racinggame.dto.RoundLogs;

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

    public RoundLogs roundRacing(StateGenerator stateGenerator) {
        RoundLogs roundLogs = new RoundLogs();
        for (Car car : cars) {
            car.move(stateGenerator);
            roundLogs.addRoundLog(RoundLog.from(car));
        }
        return roundLogs;
    }

    public Names findWinners() {
        Location bestRecord = findBestRecord();

        String text = cars.stream()
                .filter(car -> bestRecord.isSameLocation(car.getLocation()))
                .map(car -> String.valueOf(car.getName()))
                .collect(Collectors.joining(","));

        return Names.from(text);
    }

    private Location findBestRecord() {
        int bestRecord = cars.stream()
                .mapToInt(car -> car.getLocation())
                .max().getAsInt();
        return new Location(bestRecord);
    }
}
