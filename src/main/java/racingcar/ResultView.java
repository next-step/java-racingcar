package racingcar;

public class ResultView {

  private final Racing racing;

  public ResultView(Racing racing) {
    this.racing = racing;
  }

  public void print() {
    System.out.println("실행 결과");
    System.out.println(racing.currentSituation());
  }
}
