package step3;

public class ResultView {

  private static final String MOVED = "-";

  public void showResult(Result result) {
    System.out.println("실행 결과");
    for (int i = 0; i < result.size(); i++) {
      printRound(result.get(i));
    }
  }

  private void printRound(Car[] cars) {
    for (Car car : cars) {
      System.out.println(MOVED.repeat(car.getScore()));
    }
    System.out.println();
  }
}
