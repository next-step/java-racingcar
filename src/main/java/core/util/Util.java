package core.util;

import core.car.Car;
import java.util.List;

public class Util {

  public void printErrorMsg(String msg) {
    System.out.println("[ERROR] " + msg);
  }

  public void printMsg(String msg) {
    System.out.println(msg);
  }

  public static String joinListWithComma(List<Car> list) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i).getName());
      if (i < list.size() - 1) {
        sb.append(", ");
      }
    }

    return sb.toString();
  }

  public Integer getRandomNumFromZero(Integer range) {
    double dValue = Math.random();
    return (Integer) (int) (dValue * range);
  }
}
