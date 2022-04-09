package racingCar;

public final class OutputTable {

  private final static String OUTPUT_RESULT = "결과: ";

  public static void main(String[] args) {
    InputTable.howManyCar();
    InputTable.howManyGame();
    System.out.println(OUTPUT_RESULT);
    InputTable.TRACK.play();
  }
}
