package racingcar.race;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class RaceResult {

    private List<Cars> race;
    private List<Car> winnerCars;

    public RaceResult(Race race) {
        this.race = race.getRace();
    }

    public void printRaceResult() {
        ResultView.printResultTitle();
        for (Cars cars : race) {
            printEachRaceOfCarStatus(cars);
        }
        printWinnerOfRace();
    }

    private void printEachRaceOfCarStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            ResultView.printCarStatus(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private void printWinnerOfRace() {
        judgeWinnerOfRace();
        ResultView.printWinnerCars(winnerCars);
    }

    private void judgeWinnerOfRace() {
        Cars finalResult = race.get(race.size() - 1);
        winnerCars = finalResult.getCars().stream()
                .collect(groupingBy(Car::getPosition))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();
    }

}
