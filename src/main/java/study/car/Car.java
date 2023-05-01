package study.car;

public class Car {
  private String name;

  public Car(String name) {
    this.name = name;
    validate();
  }

  public String getName() {
    return name;
  }

  void validate() {
    if(name == null) {
      throw new NullPointerException();
    }

    if(name.length() > 5) {
      throw new IllegalStateException();
    }
  }

  public static Car[] createCarsAsStr(String str) {
    String[] cars = str.split(",");
    Car[] ret = new Car[cars.length];
    for(int i =0; i< cars.length; ++i) {
      ret[i] = new Car(cars[i]);
    }

    return ret;
  }
}
