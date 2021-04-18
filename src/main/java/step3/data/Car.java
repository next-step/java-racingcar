package step3.data;

import java.util.Random;

public class Car {

  private Integer position;

  public Car() {
    this.position = 0;
  }

  public boolean move() {
    Random random = new Random();
    if (random.nextInt() >=4) {
      this.position ++;
      return true;
    }
    return false;
  }
}
