package racing.types;

public class RacingCarName {

  private static final int MAZ_CAR_NAME_LEN = 5;

  private final String name;

  public RacingCarName(String racingCarName) {
    if (racingCarName == null || racingCarName.isEmpty()) {
      throw new IllegalArgumentException("차 이름은 비어있을 수 없습니다.");
    }
    if (racingCarName.length() > MAZ_CAR_NAME_LEN) {
      throw new IllegalArgumentException("차 이름은 5글자를 초과할 수 없습니다.");
    }
    this.name = racingCarName;
  }

  public String getName() {
    return name;
  }

}
