package racingcar;

import java.util.*;

public class CarRace {

    public static final int LIMIT_BOUND = 10;
    private int tryCnt;
    private List<Car> cars = new ArrayList<Car>();
    private List<RaceSnapshot> raceResult = new ArrayList<>();
    public static Random random = new Random();

    public CarRace(int carCnt, int tryCnt) {
        this.tryCnt = tryCnt;
        for(int i=0; i < carCnt; i++){
            cars.add(new Car());
        }
    }

    public void race(){
        for(int i=0; i < tryCnt; i++) {
            List<CarSnapshot> carSnapshotList = moveCars();
            RaceSnapshot raceSnapshot = new RaceSnapshot(carSnapshotList);
            raceResult.add(raceSnapshot);
        }
    }

    private List<CarSnapshot> moveCars() {
        List<CarSnapshot> carSnapshotList = new ArrayList<>();
        for (int j = 0; j < cars.size(); j++) {
            cars.get(j).go(getRandom());
            carSnapshotList.add(cars.get(j).snapshot());
        }
        return carSnapshotList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public List<RaceSnapshot> getRaceResult() {
        return raceResult;
    }

    public int getRandom(){
        return random.nextInt(LIMIT_BOUND);
    }
}
