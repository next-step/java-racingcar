public class RacingCar {

  public static final int MAX_NAME_LENGTH = 5;

  private String name;
  private int progress;

  private RacingCar() { }

  public RacingCar(String name) {
    this.name = substringIfExceedMaxLength(name);
    this.progress = 0;
  }

  private String substringIfExceedMaxLength(String name) {
    if (!Strings.isBlank(name) && name.length() > MAX_NAME_LENGTH) {
      return name.substring(0, MAX_NAME_LENGTH);
    }
    return name;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMovable()) {
      moveForward();
    }
  }

  private void moveForward() {
    progress++;
  }

  public boolean equalsProgress(int progress) {
    return this.progress == progress;
  }


  public int getProgress() {
    return this.progress;
  }

  public String getName() {
    return this.name;
  }

}
