package step3;

public class Main {

  public static void main(String[] args) {
    int numOfCar = InputView.getNumOfCars();
    int numOfMove = InputView.getNumOfMove();

    CarRacing carRacing = new CarRacing(numOfCar, numOfMove);
    carRacing.startRacing();
  }
}
