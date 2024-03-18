package carRacing;

import car.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {


    private final int carCount;
    private final int carMoveCount;
    private List<List<Integer>> resultList = new ArrayList<>();
    private List<Map<String, Integer>> resultMapList = new ArrayList<>();
    private List<Car> cars;

    public Racing(int carCount, int carMoveCount) {

        //차량 수 세팅
        this.carCount = carCount;
        //차량 이동 횟수 세팅
        this.carMoveCount = carMoveCount;

        setCars();
    }

    /**
     * 직접 차량을 설정하여 세팅할 경우
     * @param cars
     * @param carMoveCount
     */
    public Racing(List<Car> cars, int carMoveCount) {

        //차량 수 세팅
        this.carCount = cars.size();
        //차량 이동 횟수 세팅
        this.carMoveCount = carMoveCount;
        this.cars = cars;
    }

    public Racing(String carNames, int carMoveCount) {
        String[] names = carNames.split(",");
        this.carCount = names.length;
        this.carMoveCount = carMoveCount;
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public void startRacingCar() {
        for (int i = 0; i < carMoveCount; i++) {
            moveCars();
            setRacingReslutEachRound();
        }
    }

    private void setRacingReslutEachRound() {
        List<Integer> carLocationList = new ArrayList<>();
        HashMap<String, Integer> carLocationMap = new HashMap<>();
        for (Car car : cars) {
            carLocationList.add(car.getLocation());
            carLocationMap.put(car.cardName(), car.getLocation());
        }
        resultList.add(carLocationList);
        resultMapList.add(carLocationMap);
    }

    public List<List<Integer>> getResultList() {
        return resultList;
    }

    public List<Map<String,Integer>> racingResultMap(){
        return resultMapList;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void setCars() {
        cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            cars.add(new Car());
        }
    }

    public List<Car> Cars(){
        return this.cars;
    }
}
