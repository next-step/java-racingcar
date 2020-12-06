package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private final int carCount;
    private final int moveCount;
    private final Map<Integer, List<RacingCar>> racingCarMap = new HashMap<>();

    public RacingGame(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
        for (int i = 0; i < moveCount; i++) {
            setRacingCarMap(i);
        }
    }

    public Map<Integer, List<RacingCar>> getRacingCarMap() {
        return racingCarMap;
    }

    private void setRacingCarMap(int racingCarMapKey) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int j = 0; j < carCount; j++) {
            RacingCar car = new RacingCar(moveCount);
            car.race();
            racingCarList.add(car);
        }
        racingCarMap.put(racingCarMapKey, racingCarList);
    }

}
