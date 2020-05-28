package racinggame.model.domain;

public class CarDTO {

  private final String name;
  private final int distance;

  private CarDTO(String name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public static CarDTO newInstace(Car car) {
    return new CarDTO(car.getName(), car.getDistance());
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }
}
