package racingCar;

public final class OutputTable {

  private final static String OUTPUT_RESULT = "결과: ";

  public static void main(String[] args) {
    InputTable.howManyCar();
    InputTable.howManyGame();

    System.out.println(OUTPUT_RESULT);
    play();
  }

  public static void play() {
    for (int i = 0; i < InputTable.TRACK.getGameCount(); i++) {
      for (Car car : InputTable.TRACK.getCars()) {
        car.carMeter();
        System.out.println(car.move());
      }
      System.out.println();
    }
  }
}
