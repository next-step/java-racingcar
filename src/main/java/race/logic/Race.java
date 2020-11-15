package race.logic;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private List<RaceScore> latestRaceResult;

    public Race(EngineFactory factory, List<String> carNames) {
        if(carNames.size() <= 0) throw new IllegalArgumentException("carNames");

        cars = carNames.stream()
                .map(name -> new Car(factory.createEngine(), name))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<RaceScore> lap() {
        return latestRaceResult = cars.stream().map(Car::run).collect(Collectors.toUnmodifiableList());
    }

    public List<RaceScore> getFrontLine() {
        int maxPosition = latestRaceResult.stream()
                .mapToInt(RaceScore::getPosition)
                .max()
                .getAsInt();
        return latestRaceResult.stream()
                .filter(score -> score.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList());
    }
}
