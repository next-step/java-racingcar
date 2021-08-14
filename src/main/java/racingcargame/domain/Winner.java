package racingcargame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private static final String NO_WINNER = "";

    private final List<String> carNames;

    public Winner(List<RacingCar> cars) {
        carNames = findWinners(cars);
    }

    private List<String> findWinners(List<RacingCar> cars) {
        cars.sort(Collections.reverseOrder());
        List<String> winners = new ArrayList<>();
        RacingCar winner = cars.get(0);

        winners.add(winner.showCarName());
        for (int i = 1; i < cars.size(); i++) {
            winners.add(selectTie(cars.get(i), winner.showDistance()));
        }
        winners.removeAll(Collections.singleton(NO_WINNER));
        return winners;
    }

    private String selectTie(RacingCar car, int winnerDistance) {
        if (car.isWinner(winnerDistance)) {
            return car.showCarName();
        }
        return NO_WINNER;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}