package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();;

   public void prepareCars(int carCount) {
        for(int count=0; count<carCount; count++) {
            Car carModel = new Car();
            carList.add(carModel);
        }
    }

    public List<Car> carList() {
       return this.carList;
    }
}
