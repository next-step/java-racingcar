package camp.nextstep.racingcar.domain;

public class CarName {

  private final String name;

  public CarName(String name) {
    if (name == null || name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
