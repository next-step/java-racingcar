package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> winnerList;

    public Winner(List<Car> carList) {
        this.winnerList = winner(carList);
    }

    private List<Car> winner(List<Car> carList) {
        return winnerList(carList, maxPosition(carList));
    }

    private int maxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .filter(car -> car >= 0)
                .max()
                .orElse(0);
    }

    private List<Car> winnerList(List<Car> carList, int maxPosition) {
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }
}