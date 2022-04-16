import controller.TrafficController;

public class CarRacingApp {

  public static void main(String[] args) {
    TrafficController.init()
        .insertCarCount()
        .createCars()
        .insertTryCount()
        .start();
  }
}
