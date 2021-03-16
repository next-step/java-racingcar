package racingcar.domain;

public class Car {

  private final Position position;
  private final CarName name;

  public Car(String name) {
    this.name = new CarName(name);
    this.position = new Position(0);
  }

  public static Car createCar(final String name) {
    return new Car(name);
  }

  public CarName getName() {
    return name;
  }

  public Position getPosition() {
    return position;
  }

  public void moveCar(MovingStrategy movingStrategy) {
    if(movingStrategy.moveable())
      position.updatePosition();
  }

  public String printNameWithCurrentPosition() {
    String position = positionToLine();
    return name.toString() + " : " + position;
  }

  private String positionToLine() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i <= position.toInt(); i++){
      sb.append('-');
    }
    return sb.toString();
  }

  public boolean isWinner(Position maxPosition) {
    return position.equals(maxPosition);
  }

  public Position getMaxPosition(Position maxPosition) {
    if(position.lessThen(maxPosition)) {
      return maxPosition;
    }
    return position;
  }
}
