package racing.domain;

import racing.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars implements RandomNumberGenerator{

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> move(){
        for (Car car : cars) {
            car.move(randomNumber());
            System.out.println(car.toString());
        }
        return cars;
    }

    public List<Car> findWinners() {
        return getCars(getMaxPosition());
    }

    private List<Car> getCars(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
