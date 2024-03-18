package racingcar.step4.domain.factory;

import racingcar.step4.domain.Car;
import racingcar.step4.domain.Cars;
import racingcar.step4.domain.strategy.RandomCarMoveStrategy;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.step4.domain.CarName.MUST_EXCEED_CERTAIN_LENGTH;
import static racingcar.step4.domain.CarName.NAME_MINIMUM_LENGTH;

public class CarFactory {

  public static final String NAME_SEPARATOR = ",";

  private CarFactory() {
  }

  public static Cars of(String inputName) {
    return manufacture(inputName);
  }

  private static Cars manufacture(String inputName) {
    if (Objects.isNull(inputName) || inputName.length() < NAME_MINIMUM_LENGTH) {
      throw new IllegalArgumentException(String.format(MUST_EXCEED_CERTAIN_LENGTH, NAME_MINIMUM_LENGTH, inputName));
    }
    String[] names = inputName.split(NAME_SEPARATOR);

    return new Cars(Arrays.stream(names)
        .map(name -> new Car(name, new RandomCarMoveStrategy()))
        .collect(Collectors.toList()));
  }
}
