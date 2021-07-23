package racing;


import racing.view.RacingView;

import java.util.HashMap;
import java.util.Map;

public class RacingCar {

    Map<Integer, Integer> carMoveCountMap = new HashMap<>();
    RacingView racingView = new RacingView();
    public void racing(int carNum, int count) {
        for (int i = 0; i < carNum; i++) {
            carMoveCountMap.put(i, 0);
        }
        int j = 0;
        while (j < count) {
            setCarMoveCount(carNum);
            j++;
        }
    }

    void setCarMoveCount(int carNum) {
        for(int i=0; i<carNum; i++) {
            setMove(i);
        }
        racingView.printRace(carMoveCountMap, carNum);
        System.out.println("");
    }

    void setMove(int carNum) {
        if (isMove(getRandomValue())) {
            int moveCount = carMoveCountMap.get(carNum).intValue();
            carMoveCountMap.put(carNum, ++moveCount);
        }
    }

    public int getRandomValue() {
        return (int)(Math.random() * 9);
    }

    public boolean isMove(int randomValue) {
        if (randomValue >= 4) {
            return true;
        }
        return false;
    }
}
