package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racing.MovingStrategy.RandomMovingStrategy;

public class Cars {

  private final List<Car> values = new ArrayList<>();

  public Cars(String... names) {
    for (String name : names) {
      Car car = new Car(name);
      car.setMovingStrategy(new RandomMovingStrategy());
      values.add(car);
    }
  }

  public void move() {
    for (Car car : values) {
      car.moveIfMovable();
    }
  }

  public Map<String, Integer> getLocationsByName() {
    Map<String, Integer> locationsByName = new LinkedHashMap<>();

    for (Car car : values) {
      locationsByName.put(car.getName(), car.getLocation());
    }
    return Collections.unmodifiableMap(locationsByName);
  }

  public List<String> findFrontCars() {
    List<String> names = new ArrayList<>();
    int maxLocation = Integer.MIN_VALUE;

    for (Car car : values) {
      if (car.getLocation() > maxLocation) {
        maxLocation = car.getLocation();
        names.clear();
        names.add(car.getName());
      }
      else if (car.getLocation() == maxLocation) {
        names.add(car.getName());
      }
    }
    return Collections.unmodifiableList(names);
  }
}
