package study.racing.utils;

import study.racing.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingUtils {

    public static List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        Collections.sort(cars);
        Collections.reverse(cars);

        int index = 0;
        int winnerPosition = cars.get(index).getPosition();

        winners.add(cars.get(index));

        for(index=1; (cars.get(index).getPosition()==winnerPosition) && (index<cars.size()); index++) {
            winners.add(cars.get(index));
        }

        return winners;
    }
}
