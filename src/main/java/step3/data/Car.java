package step3.data;

public class Car {

  public Integer position;

  public Car() {
    this.position = 0;
  }

  public boolean move(int randomNum) {
    if (randomNum >=4) {
      this.position ++;
      return true;
    }
    return false;
  }
}
