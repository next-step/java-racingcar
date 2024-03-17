package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> cars, Distance winDistance) {
        this.winners = new ArrayList<>();
        setWinners(cars, winDistance);
    }

    private void setWinners(List<Car> cars, Distance winDistance) {
        for (Car car : cars) {
            addWinner(winDistance, car);
        }
    }

    private void addWinner(Distance winDistance, Car car) {
        if (car.isWinner(winDistance)) {
            this.winners.add(car);
        }
    }


    public List<String> getNameStrings() {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName().get());
        }
        return names;
    }

}
