package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {

    private static final int EQUAL = 0;

    public static List<Car> sort(List<Car> cars) {
        Collections.sort(cars, Collections.reverseOrder());
        return cars;
    }

    //TODO: view에서 해야할 일을 model에서 하고 있다.
    //TODO: winner만 뽑아서 전달해보자 , 출력form은 view에서 생성!!
    public static List<Car> findWinner(List<Car> cars) {

        sort(cars);

        List<Car> winners = new ArrayList<>();
        boolean isAll = false;
        for (int i = 1; i < cars.size() && !isAll; i++) {
            isAll = addWinner(cars.get(i-1), cars.get(i), winners);
        }

        return winners;
    }

    private static boolean addWinner(Car before, Car after, List<Car> winners) {

        if (winners.isEmpty()) {
            winners.add(before);
        }

        int res = before.compareTo(after);
        if (res != EQUAL) return true;

        winners.add(after);
        return false;
    }
}
