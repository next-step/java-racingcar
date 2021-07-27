package step3;

public class Car {

  public static final int MIN = 0;
  public static final int MAX = 9;
  public static final int BOUNDARY = 4;
  public static final int INITIAL_LOCATION = 0;

  private final Name name;
  private int location = INITIAL_LOCATION;

  public Car(Name name) {
    this.name = name;
  }

  protected Car(Name name, int location) {
    this.name = name;
    this.location = location;
  }

  public void move(int randomNumber) {
    validate(randomNumber);

    if (randomNumber >= BOUNDARY) {
      location++;
    }
  }

  private void validate(int randomNumber) {
    if (randomNumber < MIN || randomNumber > MAX) {
      throw new IllegalArgumentException("전진하는 조건은" + MIN + "-" + MAX + " 사이만 가능하다.");
    }
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return name.getName();
  }
}
