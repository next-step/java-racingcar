package game.domain;

import game.util.ResultView;

import java.util.List;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void printDistances(){
        for(Car car : cars){
            car.printDistance();
        }
        ResultView.printPlainMessage("");
    }
}
