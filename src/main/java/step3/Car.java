package step3;

public class Car {

  public static final int MIN = 0;
  public static final int MAX = 9;
  public static final int BOUNDARY = 4;
  private int location = 0;

  public void move(int randomNumber) {
    validate(randomNumber);

    if (randomNumber >= BOUNDARY) {
      location++;
    }
  }

  private void validate(int randomNumber) {
    if (randomNumber < MIN || randomNumber > MAX) {
      throw new IllegalArgumentException("전진하는 조건은 0-9 사이만 가능하다.");
    }
  }

  public int getLocation() {
    return location;
  }
}
