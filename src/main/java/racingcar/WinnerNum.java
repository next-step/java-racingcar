package racingcar;

import java.util.List;

public class WinnerNum {
    public static int getWinnerNum(List<Car> cars) {
        int max = 0;
        for(Car car : cars) {
            max = car.compareNum(max);
        }
        return max;
    }
}
