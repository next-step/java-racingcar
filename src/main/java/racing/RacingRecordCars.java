package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRecordCars {
    private final List<RacingRecordCar> racingRecordCars;

    private RacingRecordCars(RacingCars racingCars) {
        List<RacingRecordCar> racingRecordCars = new ArrayList<>();
        for (RacingCar racingCar: racingCars.getRacingCars()) {
            racingRecordCars.add(new RacingRecordCar(racingCar));
        }
        this.racingRecordCars = racingRecordCars;
    }

    private RacingRecordCars(List<RacingRecordCar> racingRecordCars) {
        this.racingRecordCars = racingRecordCars;
    }

    public static RacingRecordCars init(RacingCars racingCars) {
        return new RacingRecordCars(racingCars);
    }

    public RacingRecordCars getLeads() {
        List<Integer> carLocations = this.racingRecordCars
                .stream()
                .map(RacingRecordCar::getPosition)
                .collect(Collectors.toList());

        int theFarthestLocation = Collections.max(carLocations);

        List<RacingRecordCar> winners = this.racingRecordCars
                .stream()
                .filter(car -> car.getPosition() == theFarthestLocation)
                .collect(Collectors.toList());

        return new RacingRecordCars(winners);
    }

    public List<String> getNames() {
        return this.racingRecordCars
                .stream()
                .map(RacingRecordCar::getName)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return this.racingRecordCars.size();
    }

    public boolean containName(final String name) {
        return this.racingRecordCars
                .stream()
                .anyMatch(racingCar -> racingCar.getName().equals(name));
    }

    public List<RacingRecordCar> getRacingRecordCars() {
        return racingRecordCars;
    }
}
