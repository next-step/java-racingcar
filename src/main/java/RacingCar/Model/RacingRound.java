package RacingCar.Model;

import java.util.ArrayList;
import java.util.Random;

public class RacingRound {
    private static final int RANDOM_NUM_LIMIT = 10;

    public ArrayList<Car> roundStart(ArrayList<Car> cars) {
        for (Car car : cars)
            car.move(getRandomNumber(RANDOM_NUM_LIMIT));

        return cars;
    }

    public ArrayList<Car> getWinner(ArrayList<Car> cars) {
        Winner winner = new Winner();
        winner.makeWinner(cars);

        return winner.getWinners();
    }

    private static int getRandomNumber(int num) {
        Random random = new Random();
        int result = random.nextInt(num);

        return result;
    }


}
