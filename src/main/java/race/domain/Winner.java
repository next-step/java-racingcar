package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> findWinner(List<Car> carList) {
        return exploreWinnerNames(carList, findMax(carList));
    }

    public int findMax(List<Car> carList) {
        int max = 0;
        for (Car car : carList) {
            max = new Position(car.getPosition()).getMax(max);
        }
        return max;
    }

    private List<String> exploreWinnerNames(List<Car> carList, int max) {
        List<String> winnerNames = new ArrayList<>();

        for (Car car : carList) {
            putWinnerNames(winnerNames, max, car);
        }

        return winnerNames;
    }

    private List<String> putWinnerNames(List<String> winnerNames, int max, Car car) {
        if (new Position(car.getPosition()).isSamePosition(max)) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}
