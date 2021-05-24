package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList;
    private int racingCount;

    public RacingGame() {
    }

    public RacingGame(List<Car> carList, int racingCount) {
        this.carList = carList;
        this.racingCount = racingCount;
    }

    public List<String> getWinner() {
        int max = getMaxDistance();
        List<String> winner = new ArrayList<>();
        for (Car car : carList) {
            if (max == car.getLocation()) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

    public int getMaxDistance() {
        int max = 0;
        for (Car car : carList) {
            if (max < car.getLocation()) {
                max = car.getLocation();
            }
        }
        return max;
    }

    public void runWholeRound() {
        for (int i = 0; i < racingCount; i++) {
            runOneRound();
            System.out.println();
        }
    }

    private void runOneRound() {
        for (Car car : carList) {
            car.run(new MovingCondition().isMovable());
            System.out.println(car.getCarName() + " : " + underbars(car));
        }
    }

    private String underbars(Car car) {
        String underbar = "";
        for (int i = 0; i < car.getLocation(); i++) {
            underbar += "-";
        }
        return underbar;
    }
}
