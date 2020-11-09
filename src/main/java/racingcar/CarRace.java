package racingcar;

import java.util.*;

public class CarRace {

    public static final int LIMIT_BOUND = 10;
    private int tryCnt;
    List<Car> carList = new ArrayList<Car>();
    Map<Integer, RaceSnapshot> raceResult = new HashMap<Integer, RaceSnapshot>();
    public static Random random = new Random();

    public CarRace(int carCnt, int tryCnt) {
        this.tryCnt = tryCnt;
        for(int i=0; i < carCnt; i++){
            carList.add(new Car());
        }
    }

    public void race(){
        for(int i=0; i < tryCnt; i++) {
            List<CarSnapshot> carSnapshotList = moveCars();
            RaceSnapshot raceSnapshot = new RaceSnapshot(carSnapshotList);
            raceResult.put(i, raceSnapshot);
        }
    }

    private List<CarSnapshot> moveCars() {
        List<CarSnapshot> carSnapshotList = new ArrayList<>();
        for (int j = 0; j < carList.size(); j++) {
            carList.get(j).go(getRandom());
            carSnapshotList.add(new CarSnapshot(carList.get(j)));
        }
        return carSnapshotList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public Map<Integer, RaceSnapshot> getRaceResult() {
        return raceResult;
    }

    public int getRandom(){
        return random.nextInt(LIMIT_BOUND);
    }
}
