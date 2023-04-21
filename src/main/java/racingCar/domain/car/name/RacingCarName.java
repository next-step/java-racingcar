package racingCar.domain.car.name;

import racingCar.exception.InvalidRacingCarNameException;
import util.StringUtils;

public class RacingCarName {

  private static final int ALLOWED_NAME_LENGTH = 5;

  private final String name;

  public RacingCarName (String name) {
    throwErrorIfCarNameExceed(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void throwErrorIfCarNameExceed(String carName) {
    if (StringUtils.isBlank(carName)) {
      throw new InvalidRacingCarNameException("자동차의 이름이 없습니다.");
    }

    if (carName.length() > ALLOWED_NAME_LENGTH) {
      throw new InvalidRacingCarNameException(String.format(
          "자동차의 이름이 %d 글자입니다. %d자 이하로 설정해주세요", carName.length(), ALLOWED_NAME_LENGTH
      ));
    }
  }
}
