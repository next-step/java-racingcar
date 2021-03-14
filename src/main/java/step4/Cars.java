package step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    Cars(String[] carNames){
        cars = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++){
            Car car = new Car(carNames[i]);
            cars.add(car);
        }
    }

    void move(MoveStrategy moveStrategy){
        for(int i = 0; i < cars.size(); i++){
            cars.get(i).move(moveStrategy);
        }
    }

    Car getCar(int i){
        return cars.get(i);
    }

    int getNumberOfCars(){
        return cars.size();
    }

}
