package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.Collections;
import java.util.List;

public class Ranking {

    public static List<Car> sortRanking(List<Car> cars) {
        Collections.sort(cars);
        return cars;
    }

    public static String findWinner(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        int count = cars.size();
        int i=0;

        for (i = 0; i < count-1; i++) {
            int res = cars.get(i).compareTo(cars.get(i+1));
            if (res < 0) break;

            stringBuilder.append(cars.get(i).getName() + ", ");
        }
        stringBuilder.append(cars.get(i).getName() + "가 최종 우승했습니다.");

        return stringBuilder.toString();
    }
}
