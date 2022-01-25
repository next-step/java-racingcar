package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayRacingGame {

    public List<Integer> makeRandomNumbers(int carNum, Random random) {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int count = 0; count < carNum; count++) {
            int randomValue = random.nextInt(9);
            randomNumberList.add(randomValue);
        }

        return randomNumberList;
    }

    public List<Winner> findWinner(Cars cars, int maxLocation) {
        List<Winner> winnerUsers = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getLocation() == maxLocation) {
                winnerUsers.add(new Winner(car.getCarName()));
            }
        }
        return winnerUsers;
    }

}
