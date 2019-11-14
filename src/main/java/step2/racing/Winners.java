package step2.racing;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Winners {
    private static final String DELIMITER = ", ";
    private List<Model> winners;

    public Winners(List<Car> cars) {
        int max = calculateMaxScore(cars);
        this.winners = cars.stream().filter(car -> car.checkFinalScore() == max)
                .map(Car::getModel)
                .collect(toList());

    }

    private int calculateMaxScore(List<Car> cars) {
        return cars.stream()
                .map(Car::checkFinalScore)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(Model::toString)
                .reduce((o1, o2) -> o1 + DELIMITER + o2)
                .orElseThrow(IllegalArgumentException::new);
    }
}
