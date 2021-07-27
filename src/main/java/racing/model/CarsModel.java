package racing.model;

import java.util.ArrayList;
import java.util.List;

public class CarsModel {
    private List<CarModel> carList = new ArrayList<>();;

   public void prepareCars(int carCount) {
        for(int count=0; count<carCount; count++) {
            CarModel carModel = new CarModel();
            carList.add(carModel);
        }
    }

    public List<CarModel> carList() {
       return this.carList;
    }
}
