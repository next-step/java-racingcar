package step5.model;

import step5.utility.ReturnRandomValue;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars =  cars;
    }

    public static Cars makeCars(List<Car> cars){
        return new Cars(cars);
    }

    public Winners findWinners() {
        return new Winners(filterWinners(getMaxPosition()));
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            int position = car.getPosition();

            if(position > maxPosition ){
                maxPosition =  position;
            }
        }
        return maxPosition;
    }

    private List<Car> filterWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if(car.equalsPosition(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }

    public void carsMove(){
        for (Car car : cars) {
            car.move(ReturnRandomValue.returnValue());
        }
    }
}
