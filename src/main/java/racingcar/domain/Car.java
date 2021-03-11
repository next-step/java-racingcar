package racingcar.domain;

public class Car {

  private static final int MOVEABLE_CRITERIA = 4;

  private int position = 0;

  public static Car createCar() {
    return new Car();
  }

  public int getPosition() {
    return position;
  }

  public void moveCar(int generatedRandomNumber) {
    if(isMoveable(generatedRandomNumber))
      this.position++;
  }

  private boolean isMoveable(int generatedRandomNumber) {
    return generatedRandomNumber >= MOVEABLE_CRITERIA;
  }

  public String positionToLine() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i <= position; i++){
      sb.append('-');
    }
    return sb.toString();
  }
}
