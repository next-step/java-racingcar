package carracing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Car {

  private String name;
  private Positions positions;

  public Car(String name) {
    this.name = name;
    this.positions = new Positions();
  }

  public String getName() {
    return name;
  }

  public Positions getPositions() {
    return positions;
  }

  public Integer getFinalPosition() {
    return positions.getFinalPosition();
  }

  public void move(BooleanSupplier canMove) {
    positions.move(canMove.getAsBoolean());
  }
}
