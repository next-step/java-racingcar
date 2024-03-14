package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCar {
    private List<Car> cars;

    public WinnerCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<Name> getWinnerName(Position maxPosition){
       return getWinner(maxPosition).stream()
               .map(Car::getName)
               .collect(Collectors.toList());
    }

    public List<Car> getWinner(Position maxPosition) {
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().equals(maxPosition)) {
                winner.add(car);
            }
        }
        return winner;
    }
}
