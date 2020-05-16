package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
  private int position;

  private Car (int position) {
    this.position = position;
  }

  public void going (int n) {
    this.position += n;
  }

  public int getPosition () {
    return this.position;
  }

  public String toString () {
    String str = "";
    for (int i = 0; i < this.position; i++) str += "-";
    return str;
  }

  public static Car of (int position) {
    return new Car(position);
  }
}
