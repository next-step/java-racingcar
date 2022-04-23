package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public Cars(int countOfCar) {
        for (int i =0; i < countOfCar; i++) {
            Car car = new Car();
            this.carList.add(car);
        }
    }

    public void carsMove(int index, int randomNumber) {
        this.carList.get(index).move(randomNumber);
    }

    public int carsSize(){
        return this.carList.size();
    }

    public String makePosition(int index){
        return this.carList.get(index).makePosition();
    }
}
