package carRacing;

import car.Car;

import java.util.ArrayList;
import java.util.List;

public class Racing {


    private final int carCount;
    private final int carMoveCount;
    private List<List<Integer>> resultList;
    private List<Car> cars;

    /**
     * 기본값을 기준으로 세팅할 경우
     * @param carCount
     * @param carMoveCount
     */
    public Racing(int carCount, int carMoveCount) {

        //차량 수 세팅
        this.carCount = carCount;
        //차량 이동 횟수 세팅
        this.carMoveCount = carMoveCount;

        resultList = new ArrayList<>();

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

        resultList = new ArrayList<>();

        this.cars = cars;
    }

    public void startRacingCar() {
        for (int i = 0; i < carMoveCount; i++) {
            moveCars();
            setRacingReslutEachRound();
        }
    }

    private void setRacingReslutEachRound() {
        List<Integer> carLocationList = new ArrayList<>();
        for (Car car : cars) {
            carLocationList.add(car.getLocation());
        }
        resultList.add(carLocationList);
    }

    public List<List<Integer>> getResultList() {
        return resultList;
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
}
