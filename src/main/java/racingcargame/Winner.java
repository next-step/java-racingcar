package racingcargame;

import java.util.Collections;
import java.util.List;

public class Winner {
    private String name;

    public String findWinners(List<RacingCar> cars) {
        cars.sort(Collections.reverseOrder());

        Distance distance = new Distance(cars.get(0));
        RacingCarName carName = new RacingCarName(cars.get(0));

        int winnerDistance = distance.showWinnerDistance(cars.get(0));
        name = carName.showWinnerName(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            name += selectTie(cars.get(i), winnerDistance);
        }
        return name;
    }

    private String selectTie(RacingCar car, int winnerDistance) {
        String tie = "";
        if(car.isWinner(winnerDistance)) {
            tie = ", " + car.showCarName();
        }
        return tie;
    }
}