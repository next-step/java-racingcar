package race.car;

import java.util.HashMap;
import java.util.List;

public class CarRaceInfo {

    private String[] raceCarNames;
    private HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList;
    private int raceTryCount;

    public CarRaceInfo(String[] raceCarNames, HashMap<String, List<CarRaceMoveInfo>> carReacMoveInfoList, int raceTryCount) {
        this.raceCarNames = raceCarNames;
        this.carReacMoveInfoList = carReacMoveInfoList;
        this.raceTryCount = raceTryCount;
    }

    public String[] getRaceCarNames() {
        return raceCarNames;
    }

    public HashMap<String, List<CarRaceMoveInfo>> getCarReacMoveInfoList() {
        return carReacMoveInfoList;
    }

    public int getRaceTryCount() {
        return raceTryCount;
    }
}
