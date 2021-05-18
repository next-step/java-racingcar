package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> carArrayList;
    private int racingCount;

    public RacingGame() {
    }

    public RacingGame(List<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }

    public RacingGame(List<Car> carArrayList, int racingCount) {
        this.carArrayList = carArrayList;
        this.racingCount = racingCount;
    }

    public List<String> getWinner() {
        int max = getMaxDistance();
        List<String> winner = new ArrayList<>();
        for (Car car : carArrayList) {
            if (max == car.getLocation()) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

    public int getMaxDistance() {
        int max = 0;
        for (Car car : carArrayList) {
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
        for (Car car : carArrayList) {
            Random random = new Random();
            int randomNumber = random.nextInt(10);
            car.run(randomNumber);
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
