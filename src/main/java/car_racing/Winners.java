package car_racing;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    List<Car> cars;

    public Winners(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getWinner() {
        return getWinCars(getMaxPosition());
    }

    private List<Car> getWinCars(Position maxPosition) {
        List<Car> winCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winCars.add(car);
            }
        }
        return winCars;
    }

    private Position getMaxPosition(){
        Position maxPosition = new Position();
        for(Car car : cars){
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
