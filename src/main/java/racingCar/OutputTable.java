package racingCar;

public final class OutputTable {

  public static void main(String[] args) {
    InputTable.howManyCar();
    InputTable.howManyGame();
    System.out.println("결과: ");
    InputTable.TRACK.play();
  }

}
