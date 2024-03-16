package racingCar.view;

import java.util.List;

public class ResultView {

  public void print(String result) {
    System.out.println(result);
  }

  public void printWinnerMessage(List<String> winners) {
    System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
  }

}