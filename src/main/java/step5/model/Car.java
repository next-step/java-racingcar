package step5.model;

import step5.strategy.Strategy;

public class Car {

  private Position position;
  private final Name name;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int position) {
    this.name = new Name(name);
    this.position = new Position(position);
  }

  public Car move(Strategy strategy) {
    if (strategy.isMovable()){
      position = position.move();
    }
    return this;
  }

  public String showCarName() {
    return name.toString();
  }

  public boolean isWinner(Position maxPosition){
    return position.isSame(maxPosition);
  }

  public Position getPosition(){
    return position;
  }

  public Position getMaxPosition(Position maxPosition) {
    if(this.position.isBigger(maxPosition)){
      return this.position;
    }
    return maxPosition;
  }

  @Override
  public String toString() {
    return "Car{" +
      "position=" + position +
      ", name=" + name +
      '}';
  }
}