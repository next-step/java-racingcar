package racingcar.domains;

import racingcar.strategies.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public int size() {
        return racingCars.size();
    }

    public int move(int carNum) {
        return racingCars.get(carNum).move(new RandomMoveStrategy());
    }

    public String getCarName(int carNum) {
        return racingCars.get(carNum).getName();
    }

    public List<String> getWinnerNames() {
        int max = 0;
        List<String> winnerNames = new ArrayList<>();

        for (int i = 0; i < racingCars.size(); i++) {
            int carPosition = racingCars.get(i).getMoveCnt();
            if (carPosition >= max) {
                max = carPosition;
                winnerNames.add(racingCars.get(i).getName());
            }
        }
        return winnerNames;
    }
}
