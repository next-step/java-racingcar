package study.racing.utils;

import study.racing.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingUtils {
    private static final int MAX_RANDOM_NUM = 10;

    public static List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        Collections.sort(cars);
        Collections.reverse(cars);

        int index = 0;
        int winnerPosition = cars.get(index).getPosition();

        winners.add(cars.get(index));

        for(index=1; (index<cars.size()) && (cars.get(index).getPosition()==winnerPosition); index++) {
            winners.add(cars.get(index));
        }

        return winners;
    }

    public static int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUM);
    }
}
