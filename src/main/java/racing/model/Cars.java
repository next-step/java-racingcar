package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

   public void prepareCars(String carNames) {
       String[] carNameArr = carNames.split(",");
       for(String carName : carNameArr) {
           Car car = new Car();
           car.setCarName(carName);
           carList.add(car);
       }
    }

    public List<Car> carList() {
       return this.carList;
    }
}
