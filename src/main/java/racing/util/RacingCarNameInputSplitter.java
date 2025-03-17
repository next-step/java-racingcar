package racing.util;

import racing.types.RacingCarName;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarNameInputSplitter {

  private static final int MIN_CAR_COUNT = 2;

  public static List<RacingCarName> split(String racingCarNames) {
    if (racingCarNames == null) {
      throw new NullPointerException("차 이름들의 값은 null로 들어올 수 없습니다.");
    }

    List<String> nameList = List.of(racingCarNames.split(","));
    if (nameList.size() < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("차 이름들의 값은 2개 이상으로 들어와야 합니다.");
    }

    return nameList.stream().map(RacingCarName::new).collect(Collectors.toList());
  }
}
