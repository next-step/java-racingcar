package step3.data;

import java.util.ArrayList;
import java.util.List;
import step3.strategy.MoveStrategy;

public class Cars {
  private MoveStrategy moveStrategy;

  private List<Car> carList;

  public List<Car> getCarList() {
    return this.carList;
  }

  public Cars() {
    this.moveStrategy = new MoveStrategy();
    this.carList = new ArrayList<>();
  }

  public Cars(int input) {
    this.moveStrategy = new MoveStrategy();

    this.carList = new ArrayList<>();
    for(int i = 0; i < input; i++) {
      this.carList.add(new Car());
    }
  }

  public void race() {
    for(Car car : this.carList) {
      car.move(moveStrategy);
    }
  }
}
