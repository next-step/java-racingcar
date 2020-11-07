package race.car;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 자동차 게임의 정보를 관리하는 객체
 */
public class CarRaceMoveInfo {

    private String raceCarName;
    private int moveDistance;
    
    public CarRaceMoveInfo(String raceCarName, int moveDistance) {
        this.raceCarName = raceCarName;
        this.moveDistance = moveDistance;
    }

    public String getRaceCarName() {
        return raceCarName;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}

