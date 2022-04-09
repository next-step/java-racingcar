package racingCar;

import java.util.Random;

public final class OutputTable {

  private final static String OUTPUT_RESULT = "결과: ";
  private final static int RANDOM_BOUND_VALUE = 10;

  public static void main(String[] args) {
    InputTable.howManyCar();
    InputTable.howManyGame();

    System.out.println(OUTPUT_RESULT);
    play();
  }

  public static void play() {
    for (int i = 0; i < InputTable.TRACK.getGameCount(); i++) {
      for (Car car : InputTable.TRACK.getCars()) {
        Random random = new Random();
        car.step(random.nextInt(RANDOM_BOUND_VALUE));
        System.out.println(car.move());
      }
      System.out.println();
    }
  }
}
