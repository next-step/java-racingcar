import controller.TrafficController;

public class CarRacingApp {

  public static void main(String[] args) {
    TrafficController.init()
        .createCarsByInsertingCarNames()
        .insertTryCount()
        .start();
  }
}
