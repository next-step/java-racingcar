package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public void startRacing(int count, Cars cars) {
        for (int i = 0; i < count; i++) {
            cars.moveCars(i);
            System.out.println();
        }
    }

    public int positionCheck(Cars cars) {
        int maxPosition = 0;
        maxPosition = cars.maxPosition();
        return maxPosition;
    }

    public List<String> winner(Cars cars) {
        int max = positionCheck(cars);
        List<String> winner = cars.win(max);
        return winner;
    }
}
