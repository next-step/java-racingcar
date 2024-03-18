package step3;


import step3.object.Car;
import step3.util.NumberGenerator;
import step3.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public List<Car> generateCarList(int carCount){
        List<Car> carList = new ArrayList<>();
        for(int count = 0; count < carCount; count++){
            carList.add(new Car());
        }
        return carList;
    }

    public void startMoving(List<Car> carList){
        for (Car car : carList) {
            int chance = numberGenerator.generate();
            car.move(chance);
        }
    }
}