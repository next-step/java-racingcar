package racing;

import racing.car.Car;
import racing.dto.RacingReport;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> carList;
    private final int round;

    public Racing(List<Car> carList, int round) {
        this.carList = carList;
        this.round = round;
    }

    public RacingReport start() {
        RacingReport racingReport = new RacingReport();

        for (int i = 0; i < round; i++) {
            carList.forEach(Car::move);
            racingReport.saveRoundResult(carList);
        }

        getFrontRunner().forEach(racingReport::addWinner);

        return racingReport;
    }

    private List<String> getFrontRunner() {
        int locationOfFrontRunner = carList.stream()
                                           .map(Car::getLocation)
                                           .max(Comparator.naturalOrder())
                                           .orElse(0);

        return carList.stream()
                      .filter(car -> car.getLocation() == locationOfFrontRunner)
                      .map(Car::getName)
                      .collect(Collectors.toList());
    }

}
