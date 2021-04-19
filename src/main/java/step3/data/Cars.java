package step3.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
  private List<Car> carList;

  public List<Car> getCarList() {
    return this.carList;
  }

  public Cars() {
    this.carList = new ArrayList<>();
  }

  public Cars(int input) {
    this.carList = new ArrayList<>();
    for(int i = 0; i < input; i++) {
      this.carList.add(new Car());
    }
  }

  public void race() {
    for(Car car : this.carList) {
      car.move(new Random().nextInt(10));
    }
  }
}
