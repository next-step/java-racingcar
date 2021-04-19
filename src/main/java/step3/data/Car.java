package step3.data;

public class Car {

  private Integer position;

  public Car() {
    this.position = 0;
  }

  public Integer getPosition() {
    return this.position;
  }

  public boolean move(int randomNum) {
    if (randomNum >=4) {
      this.position ++;
      return true;
    }
    return false;
  }
}
