package study.racingCar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> winners;

    public Winner() {
        this.winners = new ArrayList<>();
    }

    public Car findTheWinner(List<Car> cars){
        Car theWinner = cars.get(0);
        for (Car car : cars) {
            theWinner = car.getTheWinner(theWinner);
        }
        return theWinner;
    }

    public List<Car> createWinners(List<Car> cars, Car winner){
        for (Car car : cars) {
            addWinners(car, winner);
        }
        return winners;
    }

    private void addWinners(Car car, Car winner){
        if (car.isSamePosition(winner)){
            winners.add(car);
        }
    }

}
