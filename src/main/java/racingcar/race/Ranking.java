package racingcar.race;

import racingcar.car.Car;

import java.util.Collections;
import java.util.List;

public class Ranking {
    private static final int WINNER = 1;
    private static final int LOSER = 0;

    private int topPosition = 0;

    public Ranking(int topPosition, List<Car> cars) {
        this.topPosition = topPosition;
        sortRank(cars);
    }

    public void sortRank(List<Car> cars) {
        Collections.sort(cars);
    }

    public int countWinner(List<Car> cars) {
        int winner = 0;

        for(Car car : cars) {
            winner += checkWinner(car);
        }

        return winner;
    }

    private int checkWinner(Car car) {
        if(car.isWinner(this.topPosition)) {
            return WINNER;
        }
        return LOSER;
    }

}
