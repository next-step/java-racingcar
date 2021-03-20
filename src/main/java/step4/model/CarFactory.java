package step4.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  private static final String VARIABLE_NAME_SPLIT = ",";

  private CarFactory(){}

  public static Cars makeCars(String carNames) {
    return makeCarsWithMinimumLocs(carNames, 0);
  }

  public static Cars makeCarsWithMinimumLocs(String carNames, int minimumLoc){
    List<Car> carList = new ArrayList<>();
    String[] carNameArr = splitCars(carNames);
    for(String name: carNameArr) carList.add(new Car(name, minimumLoc));

    return new Cars(carList);
  }

  private static String[] splitCars(String carNames){
    return carNames.split(VARIABLE_NAME_SPLIT);
  }

}
