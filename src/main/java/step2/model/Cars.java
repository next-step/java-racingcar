package step2.model;

import step2.util.Utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(this.cars);
    }

    public void move() {
        for(Car car : cars){
            int carPositionStatusNumber = Utils.createRandomNumber();
            car.carPositionUpdate(carPositionStatusNumber);
        }
    }

    public List<Car> maxPostionCarName(){
        int winnerPostion = maxPosition();
        return cars.stream()
                .filter(car -> isWinnerPosition(car, winnerPostion))
                .collect(Collectors.toList());
    }

    public int maxPosition(){
        return cars.stream()
                .mapToInt(car -> car.lastCarPosition())
                .max()
                .getAsInt();
    }

    private boolean isWinnerPosition(Car car, int winnerPostion){
        return car.lastCarPosition() == winnerPostion;
    }

}
