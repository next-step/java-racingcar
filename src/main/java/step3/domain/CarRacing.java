package step3.domain;

import step3.model.InputData;

import java.util.ArrayList;

public class CarRacing {
    private ArrayList<Car> carList;
    private final int numCar;
    private final int numTry;

    public CarRacing(InputData inputData) {
        this.numCar = inputData.getNumCar();
        this.numTry = inputData.getNumTry();
    }

    public ArrayList<ArrayList<DistanceStatus>> start(MoveStrategy randomMoveStrategy) {
        return carRacing(createCarList(), randomMoveStrategy);
    }

    private ArrayList<Car> createCarList() {
        carList = new ArrayList<>();
        for (int i = 0; i < numCar; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public ArrayList<ArrayList<DistanceStatus>> carRacing(ArrayList<Car> carList, MoveStrategy randomMoveStrategy) {
        ArrayList<ArrayList<DistanceStatus>> results = new ArrayList<>();
        for (int i = 0; i < numTry; i++) {
            ArrayList<DistanceStatus> distanceStatus = race(carList, randomMoveStrategy);
            results.add(distanceStatus);
        }
        return results;
    }

    private ArrayList<DistanceStatus> race(ArrayList<Car> carList, MoveStrategy randomMoveStrategy) {
        ArrayList<DistanceStatus> distanceStatus = new ArrayList<>();
        for (Car car : carList) {
            car.tryMove(randomMoveStrategy);
            distanceStatus.add(new DistanceStatus(car.getDistance()));
        }
        return distanceStatus;
    }
}
