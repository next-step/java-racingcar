package racingcar.service;

import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SystemService extends Util {

    public List<Car> carInfo = new ArrayList<>();

    private static final int RANDOM_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    public void splitString(String input) {
        String[] result = input.split(",");
        for (int i = 0; i < result.length; i++) {
            Car carVO = new Car(result[i], 0);
            if (invalidedName(result[i])) {
                carInfo.add(carVO);
            }

        }
    }

    public int moveCar() {
        if (new Random().nextInt(RANDOM_NUMBER) >= MOVABLE_NUMBER) {
            return 1;
        }
        return 0;
    }

    public List<String> checkWinner(int cycle) {
        List<String> winnerName = new ArrayList<>();
        for (int i = 0; i < carInfo.size(); i++) {
            winnerName.add(selectWinnerName(i, cycle));
        }
        return winnerName;
    }

    public String selectWinnerName(int i, int cycle) {
        String winnerName = null;
        if (carInfo.get(i).getLocationInfo() == cycle) {
            winnerName = carInfo.get(i).getName();
        }
        return winnerName;
    }
}
