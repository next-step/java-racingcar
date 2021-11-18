public class RacingCar {

  public static final int MAX_NAME_LENGTH = 5;
  public static final String DEFAULT_NAME = "";

  private final String name;
  private int progress;

  public RacingCar(String name) {
    this(name, 0);
  }
  
  private RacingCar(String name, int progress) {
    this.name = substringIfExceedMaxLength(name);
    this.progress = progress;
  }

  private String substringIfExceedMaxLength(String name) {
    if (!Strings.isBlank(name) && name.length() > MAX_NAME_LENGTH) {
      return name.substring(0, MAX_NAME_LENGTH);
    }
    if (Strings.isBlank(name)) {
      return DEFAULT_NAME;
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
