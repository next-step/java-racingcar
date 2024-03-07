package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private List<Car> cars;

  public RacingCarGame() {
    this.cars = new ArrayList<>();
  }

  public void initiateGame(int carNum){
    for(int i = 0; i < carNum; i++){
      cars.add(new Car());
    }
  }

}