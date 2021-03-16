package step4.model;

import step4.util.VariableConstants;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
  private CarFactory(){}

  public static Cars makeCars(String carNames) {
    List<Car> carList = new ArrayList<>();
    String[] carNameArr = splitCars(carNames);
    for(String name: carNameArr) carList.add(new Car(name));

    return new Cars(carList);
  }

  public static Cars makeCarsWithMinimumLocs(String carNames, int minimumLoc){
    List<Car> carList = new ArrayList<>();
    String[] carNameArr = splitCars(carNames);
    for(String name: carNameArr) carList.add(new Car(name, minimumLoc));

    return new Cars(carList);
  }

  private static String[] splitCars(String carNames){
    return carNames.split(VariableConstants.VARIABLE_NAME_SPLIT.getValue());
  }

}
