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
            car = new Car(carNameArray[i]);
            this.carList.add(car);
        }
    }

    public NamedCars(List<Car> carList){
        this.carList = carList;
    }

    private String[] splitCarNames(String carNames){
        return carNames.split(",");
    }

    public List<Car> getCarList(){
        return carList;
    }


    public int getMaxForward(){
        int maxForward = 0;
        for(Car car : carList){
            if(car.getForwardCnt() >= maxForward) maxForward = car.getForwardCnt();
        }

        return maxForward;
    }
}
