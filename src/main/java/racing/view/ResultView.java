package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {
  private static final char LINE = '\n';

  public void printResult(List<Car> carList){
    StringBuilder stringBuilder = new StringBuilder();
    carList.forEach(c->{
      for(int i=0; i<c.showCarLocation(); i++) stringBuilder.append('-');
      stringBuilder.append(LINE);
    });
    System.out.println(stringBuilder.toString());
  }

  public void error(String message){
    System.out.println(message);
  }
}