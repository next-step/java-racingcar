package racing.util;

import racing.property.CarRacingGameProperty;
import racing.types.CarName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNameInputSplitter {

  public static List<CarName> split(String racingCarNames) {
    if (racingCarNames == null) {
      throw new NullPointerException("차 이름들의 값은 null로 들어올 수 없습니다.");
    }

    List<String> nameList = List.of(racingCarNames.split(","));
    if (nameList.size() < CarRacingGameProperty.MIN_CAR_COUNT) {
      throw new IllegalArgumentException("차 이름들의 값은 2개 이상으로 들어와야 합니다.");
    }

    Set<String> nameSet = new HashSet<>(nameList);
    if (nameSet.size() != nameList.size()) {
      throw new IllegalArgumentException("중복된 이름이 존재합니다.");
    }

    nameSet.stream()
        .filter(name -> name.equals(CarRacingGameProperty.CAR_DEFAULT_NAME))
        .findAny()
        .ifPresent(name -> {
          throw new IllegalArgumentException(String.format("%s 이름은 사용할 수 없습니다.", CarRacingGameProperty.CAR_DEFAULT_NAME));
        });

    return nameList.stream().map(CarName::valueOf).collect(Collectors.toList());
  }
}
