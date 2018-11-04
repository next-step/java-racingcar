package racingGame;

import java.util.ArrayList;

public class RacingGame {

    public ArrayList<Integer> move(int cars, int times) {
        if (cars < 1 || times < 0) {
            return new ArrayList<>();
        }

        int time = 0;
        ArrayList<Integer> carPositions = new ArrayList<>(cars);

        // 자동차 위치값 초기화
        for (int i = 0, len = cars; i < len; i++) {
            carPositions.add(0);
        }

        return carPositions;
    }
}
