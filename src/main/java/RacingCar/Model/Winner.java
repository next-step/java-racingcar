package RacingCar.Model;

import java.util.ArrayList;

public class Winner {
    ArrayList<Car> winners = new ArrayList<Car>();

    public ArrayList<Car> getWinners() {
        return winners;
    }

    public void makeWinner(ArrayList<Car> cars) {

        for (Car car : cars) {
            if (isWinner(car.getLocation(), winnerMaxLoaction(cars)))
                addWinner(car.getLocation(), car.getName());
        }

    }

    public void addWinner(int location, String winnerName) {
        if (!winnerName.isEmpty())
            winners.add(new Car(location, winnerName));
    }

    private boolean isWinner(int location, int maxLocation) {
        if (location == maxLocation)
            return true;

        return false;
    }

    private int winnerMaxLoaction(ArrayList<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars)
            if (car.getLocation() > maxLocation) maxLocation = car.getLocation();


        return maxLocation;
    }
}