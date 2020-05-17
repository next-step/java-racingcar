package step3.view;

import step3.Cars;

import java.util.stream.Collectors;

public class ResultView {

  private ResultView() {};

  public void print (Cars cars) {
    System.out.println(
      cars.stream()
          .map(car -> car.getPositionString())
          .collect(Collectors.joining("\n"))
    );
  }

  public static ResultView of () { return new ResultView(); }

}
