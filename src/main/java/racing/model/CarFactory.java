package racing.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public Cars makeCars(int carCount) {
    List<Car> carList = new ArrayList<>();
    while (carCount-- > 0) carList.add(new Car());

    return new Cars(carList);
  }

}
