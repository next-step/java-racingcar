package step3;

import java.util.List;

public class Cars {

    private List<Car> cars;

    Cars(int numberOfCars, MoveStrategy moveStrategy){
        for(int i = 0; i < numberOfCars; i++){
            Car car = new Car(moveStrategy);
            cars.add(car);
        }
    }

    void move(){
        for(int i = 0; i < cars.size(); i++){
            cars.get(i).move();
        }
    }

}
