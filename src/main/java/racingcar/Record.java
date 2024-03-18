package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Record {
    public static List<String> getRecord(List<Car> carList) {
        return getWinnerList(carList, findMaxPosition(carList));
    }

    public static int findMaxPosition(List<Car> carList) {
        int max = 0;
        for (Car car : carList) {
            max = car.getMax(max);
        }
        return max;
    }

    private static List<String> getWinnerList(List<Car> carList, int max) {
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            makeWinnerList(winnerList, max, car);
        }
        return winnerList;
    }

    private static List<String> makeWinnerList(List<String> winnerList, int max, Car car) {
        if (car.isMaxPosition(max)) {
            winnerList.add(car.getName());
        }
        return winnerList;
    }
}
