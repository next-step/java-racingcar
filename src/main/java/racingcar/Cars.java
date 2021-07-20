package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(CreateRandomNumber.getRandomNumber());
        }
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car);
        }
        return winners;
    }

    private void addWinner(List<Car> winners, Car car) {
        if(car.isWinner()){
            winners.add(car);
        }
    }


}
