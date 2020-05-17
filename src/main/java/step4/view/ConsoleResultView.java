package step4.view;

import step4.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView {

  private ConsoleResultView () {};

  @Override
  public void print (List<Car> cars) {
    System.out.println(
      cars.stream().map(v -> v.toString()).collect(Collectors.joining("\n"))
    );
  }

  @Override
  public void winner(String winners) {
    System.out.println(winners + "가 최종 우승했습니다.");
  }

  public static ResultView of () { return new ConsoleResultView(); }

}
