package racingCar;

import java.util.ArrayList;
import java.util.List;

public class NamedCars {

    private List<Car> carList;

    public NamedCars(String carNames){
        Car car;
        carList = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for(int i=0; i<carNameArray.length; i++) {
            car = new Car(carNameArray[i], 0);
            this.carList.add(car);
        }
    }

    private String[] splitCarNames(String carNames){
        return carNames.split(",");
    }

    public List<Car> getCarList(){
        return carList;
    }


}
