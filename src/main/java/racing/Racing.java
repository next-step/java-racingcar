package racing;

import java.util.List;
import racing.domain.Car;
import racing.view.ResultView;

public class Racing {

  public void race(List<Car> cars, int round){
    for (int i=0; i<round; i++){
      ResultView.round(i+1);
      run(cars);
    }
  }

  private void run(List<Car> cars){
    for (Car car : cars){
      car.run();
      car.showStatus();
    }
  }
}