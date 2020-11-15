package racingcar;

import java.util.*;

public class CarRace {

    public static final int LIMIT_BOUND = 10;
    private int tryCnt;
    private List<Car> cars = new ArrayList<Car>();
    private List<RaceSnapshot> raceResult = new ArrayList<>();
    private static Random random = new Random();

    public CarRace(String[] carNames, int tryCnt) {
        this.tryCnt = tryCnt;
        for(String carName : carNames){
            cars.add(new Car(carName));
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
        for (Car car : cars) {
            car.go(getRandom());
            carSnapshotList.add(car.snapshot());
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

    public List<Car> getWinnerCars() {
        List<Car> winnerCar = new ArrayList<>();
        int winnerDistance = getWinnerDistance(raceResult);
        RaceSnapshot lastRaceSnapShot = raceResult.get(raceResult.size()-1);
        for(Car car : lastRaceSnapShot.cars){
            if(car.getDistance() == winnerDistance){
                winnerCar.add(car);
            }
        }
        return winnerCar;
    }

    public int getWinnerDistance(List<RaceSnapshot> raceSnapshotList) {
        RaceSnapshot lastRaceSnapShot = raceSnapshotList.get(raceSnapshotList.size()-1);
        final Comparator<Integer> comp1 = (s1, s2) -> s1.compareTo(s2);
        int winnerDistance = lastRaceSnapShot.cars.stream()
                .max((x, y) -> x.getDistance() - y.getDistance())
                .get().getDistance();
        return winnerDistance;
    }

    public int getRandom(){
        return random.nextInt(LIMIT_BOUND);
    }

    public void setRaceResult(List<RaceSnapshot> raceResult) {
        this.raceResult = raceResult;
    }
}
