package study1.winner.code.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {

  @ParameterizedTest
  @MethodSource("maxDistanceArgument")
  @DisplayName("cars 의 최대 거리 측정 테스트")
  public void maxDistance(Cars cars, int maxDistance) {
    assertThat(cars.maxDistance()).isEqualTo(maxDistance);
  }

  private static Stream<Arguments> maxDistanceArgument() {
    return Stream.of(
      Arguments.of(new Cars(Arrays.asList(new Car("pobi", 5), new Car("tim", 3))), 5),
      Arguments.of(new Cars(Arrays.asList(new Car("pobi", 2), new Car("tim", 2))), 2) 
    );
  }

  @ParameterizedTest
  @MethodSource("winnerArgument")
  @DisplayName("winners 테스트")
  public void winners(Cars cars, List<String> winners) {
    List<String> names = cars.winners();

    assertThat(names).hasSameElementsAs(winners);
  }

  private static Stream<Arguments> winnerArgument() {
    return Stream.of(
      Arguments.of(
        new Cars(Arrays.asList(new Car("pobi", 5), new Car("tim", 3))), 
        Arrays.asList("pobi")
      ),
      Arguments.of(
        new Cars(Arrays.asList(new Car("pobi", 2), new Car("tim", 2))), 
        Arrays.asList("pobi", "tim")
      ) 
    );
  }

}
