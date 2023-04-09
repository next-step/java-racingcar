package racing;

public class UserInput {

  private final int numberOfCars;
  private final int numberOfMovements;

  public UserInput(int numberOfCars, int numberOfMovements) {
    this.numberOfCars = numberOfCars;
    this.numberOfMovements = numberOfMovements;
  }

  public int numberOfCars() {
    return numberOfCars;
  }

  public int numberOfMovements() {
    return numberOfMovements;
  }

}
