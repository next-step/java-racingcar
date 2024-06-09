package core.car;

public interface CarInterface {

  Car createCar(String carName, Integer startPosition);

  void goForward(Car car, Integer goCost);

  String getDistanceWithString(Car car);
}
