package step3.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners pickWinners(Cars cars) {
        int winnerPosition = findWinnerPosition(cars);
        List<Car> winners = cars.getCars().stream()
                .filter(car -> isWinnerPosition(winnerPosition, car))
                .collect(Collectors.toList());

        return new Winners(winners);
    }

    private static int findWinnerPosition(Cars cars) { //TODO: Q. 이렇게 static을 난사(?)하고있는데 괜찮을까요?
        return cars.getCars().stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Integer::valueOf))
                .get();
    }

    private static boolean isWinnerPosition(int winnerPosition, Car car) {
        return car.getPosition() == winnerPosition;
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
