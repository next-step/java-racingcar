package racingcar;

import java.util.*;

public class CarRace {

    public static final int LIMIT_BOUND = 10;
    public static final int CARNAME_MAXSIZE = 5;
    private static Random random = new Random();
    private int tryCnt;
    private List<Car> cars = new ArrayList<Car>();
    private List<RaceSnapshot> raceResult = new ArrayList<>();

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
        int winnerDistance = getWinnerDistance(raceResult.get(raceResult.size()-1));
        RaceSnapshot lastRaceSnapShot = raceResult.get(raceResult.size()-1);
        for(Car car : lastRaceSnapShot.cars){
            if(car.equalDistance(winnerDistance)){
                winnerCar.add(car);
            }
        }
        return winnerCar;
    }

    public int getWinnerDistance(RaceSnapshot lastRaceSnapShot) {
        return lastRaceSnapShot.cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .get().getDistance();
    }

    public int getRandom(){
        return random.nextInt(LIMIT_BOUND);
    }

    public void setRaceResult(List<RaceSnapshot> raceResult) {
        this.raceResult = raceResult;
    }

    public static boolean carNamesValidation(String carNames){
        String[] names = splitCarNames(carNames);
        for(String name : names){
            if(name.length()> CARNAME_MAXSIZE){
                return false;
            }
        }
        return true;
    }

    public static String[] splitCarNames(String carNames){
        return carNames.split(",");
    }
}
