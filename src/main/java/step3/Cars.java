package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

  public static final int BOUNDARY = 9;
  final List<Car> carList = new ArrayList<>();

  public Cars(int numberOfCars) {
    for (int i = 0; i < numberOfCars; i++) {
      carList.add(new Car());
    }
  }

  public void move(Random random, StringBuilder output) {
    for (Car car : carList) {
      car.move(random.nextInt(BOUNDARY));
      final int location = car.getLocation();
      log(output, location);
    }
    output.append("\n");
  }

  private void log(StringBuilder output, int location) {
    output.append("-");
    output.append("-".repeat(location));
    output.append("\n");
  }

  public int numberOf() {
    return carList.size();
  }

}
