package racingcar.domain;

import racingcar.utils.CreateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private int winnerPosition;

    public Cars(String[] carNames) {
        createCar(carNames);
        winnerPosition = 0;
    }

    private void createCar(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(CreateRandomNumber.getRandomNumber());
        }
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        getWinnerPosition(cars);
        for (Car car : cars) {
            addWinner(winners, car);
        }
        return winners;
    }

    private void getWinnerPosition(List<Car> cars) {
        for (Car car : cars) {
            isMoreThanTempWinnerPosition(car);
        }
    }

    private void isMoreThanTempWinnerPosition(Car car){
        if(car.isMoreThan(winnerPosition)){
            winnerPosition =  car.getPosition();
        }
    }

    private void addWinner(List<Car> winners, Car car) {
        if(car.isMoreThan(winnerPosition)){
            winners.add(car);
        }
    }
}
