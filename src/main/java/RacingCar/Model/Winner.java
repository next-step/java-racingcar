package RacingCar.Model;

import java.util.ArrayList;

public class Winner {
    ArrayList<Car> winners = new ArrayList<Car>();

    public ArrayList<Car> getWinners() {
        return winners;
    }

    public void makeWinner(ArrayList<Car> cars) {
        for (Car car : cars)
            addWinner(car, car.chooseWinner(cars));

    }

    public void addWinner(Car car, String winnerName) {
        if (!winnerName.isEmpty())
            winners.add(new Car(car.getLocation(), winnerName));
    }
}
