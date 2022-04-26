package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final StringBuilder carsStatus = new StringBuilder();
    static final RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

    private final List<Car> cars = new ArrayList<>();
    private int winnerScore;

    public Cars(){
    }

    public Cars(String carList) {
        String[] carNames = carList.split(",");

        for (String car : carNames) {
            cars.add(new Car(car));
        }
    }

    public void add(Car car) {
        cars.add(car);
        checkWinnerScore(car);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getCarsStatus() {
        return carsStatus.toString();
    }

    public void play() {
        for (Car car : cars) {
            car.isMove(randomMovingStrategy);
            checkWinnerScore(car);
            carsStatus.append(car.getCarName() + " : " + car.showCarDistance());
            carsStatus.append("\n");
        }
        carsStatus.append("\n");
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
        if(car.isWinner(winnerScore)){
            winnerCars.add(car);
        }
    }
}