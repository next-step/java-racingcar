package racingcar;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public void createCar(){
        cars.add(new Car());
    }

    public int getSize(){
        return this.cars.size();
    }

    public Car getCar(int index){
        return cars.get(index);
    }
}


