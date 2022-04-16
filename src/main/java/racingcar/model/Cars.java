package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Cars {
    private static final StringBuilder carsStatus = new StringBuilder();

    private final List<Car> cars = new ArrayList<>();
    private int winnerScore;

    public Cars(String carList) {
        String[] carNames = carList.split(",");

        for (String car : carNames) {
            cars.add(new Car(car));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getCarsStatus() {
        return carsStatus.toString();
    }

    public void play() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        for (Car car : cars) {
            car.isMove(randomMovingStrategy);
            checkWinnerScore(car);
        }
    }

    private void checkWinnerScore(Car car) {
        if(winnerScore < car.getDistance()){
            winnerScore = car.getDistance();
        }
    }

    public List<Car> isWinners() {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            checkWinnerCar(winnerCars, car);
        }
        return Collections.unmodifiableList(winnerCars);
    }

    private void checkWinnerCar(List<Car> winnerCars, Car car) {
        if(car.getDistance() == winnerScore){
            winnerCars.add(car);
        }
    }

    public void appendCarsStatus(){
        for (Car car : cars) {
            carsStatus.append(car.getCarName() + " : " + car.showCarDistance());
            carsStatus.append("\n");
        }
        carsStatus.append("\n");
    }
}
