package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> carList;

    public RacingGame() {
    }

    public RacingGame(List<Car> carList) {
        this.carList = carList;
    }

    public void runWholeRound(int racingCount) {
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
