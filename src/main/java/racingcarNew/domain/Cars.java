package racingcarNew.domain;

import java.util.List;

public class Cars {

    private List<Car> cars;
    private int lapCount = 0;
    private static Utils utils;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getAll() {
        return cars;
    }

    private void addLapCount(){
        this.lapCount++;
    }

    public int getLapCount(){
        return lapCount;
    }

    public void moveAll() {
        addLapCount();
        for(Car car : cars){
            car.move(utils.getRandomNo());
        }
    }
}
