package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    public int calculateWinnerPosition(List<Car> cars) {
        int maxPosition = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() > maxPosition) {
                maxPosition = cars.get(i).getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> makeWinners(List<Car> cars) {
        List<String> winners = new ArrayList<String>();
        for (int i = 0; i < cars.size(); i++) {
            if (calculateWinnerPosition(cars) == cars.get(i).getPosition()) {
                winners.add(cars.get(i).getCarName());
            }
        }
        return winners;
    }
}