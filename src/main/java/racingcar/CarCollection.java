package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCollection {
    private List<Car> cars = new ArrayList<>();

    public CarCollection(List<Car> cars){
        this.cars = cars;
    }

    public int getFirstPosition(){
        if(this.cars.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return this.cars.get(0).getPosition();
    }

    public List<Car> decideWinner(List<Car> cars){
        List<Car> winners = new ArrayList<>();

        int maxPosition = this.getFirstPosition();
        for(Car selectedCar : cars){
            maxPosition = selectedCar.searchMaxPosition(maxPosition, selectedCar);
        }

        for(Car selectedCar : cars){
            selectedCar.checkPositionPerCar(maxPosition, selectedCar, winners);
        }

        return winners;
    }
}
