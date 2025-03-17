package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.types.RacingCarCount;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGroupTest {

  @DisplayName("각 자동차의 현재 위치를 정수 형태로 반환한다.")
  @Test
  void getCarLocations_returnCurrentLocations() {
    int carCount = 3;
    int simulateMoves = 5;

    RacingCarGroup carGroup = new RacingCarGroup(new RacingCarCount(carCount), () -> true);

    IntStream.range(0, simulateMoves).forEach(i -> carGroup.moveCars());

    List<Integer> carLocations = Objects.requireNonNull(carGroup.getCarLocations());

    assertAll(
        () -> assertThat(carLocations).hasSize(carCount),
        () -> carLocations.forEach(location -> assertThat(location).isEqualTo(simulateMoves))
    );
  }

  @DisplayName("차들을 move 하면 전략에 따라 차를 움직인다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void tryMoveCars_carsMovedByStrategy(boolean strategyResult) {
    int carCount = 3;
    RacingCarGroup carGroup = new RacingCarGroup(new RacingCarCount(carCount), () -> strategyResult);

    carGroup.moveCars();
    List<RacingCar> result = carGroup.copyCars();

    assertThat(result)
        .extracting(RacingCar::getLocation)
        .containsOnly(strategyResult ? 1 : 0);
  }

  @DisplayName("차들을 copy 하면 자동차 배열의 깊은 복사를 반환한다.")
  @Test
  void copyCars_returnDeepCopiedCarArray() {
    int carCount = 3;
    RacingCarGroup carGroup = new RacingCarGroup(new RacingCarCount(carCount), () -> true);

    List<RacingCar> firstCopiedRacingCars = carGroup.copyCars();
    List<RacingCar> secondCopiedRacingCars = carGroup.copyCars();

    assertAll(
        () -> assertThat(firstCopiedRacingCars).hasSize(carCount),
        () -> assertThat(secondCopiedRacingCars).hasSize(carCount),
        () -> assertThat(firstCopiedRacingCars)
            .zipSatisfy(secondCopiedRacingCars, (element1, element2) -> assertThat(element1).isNotSameAs(element2))
    );
  }

  @DisplayName("차들을 reset 하면 차의 위치가 0이 된다.")
  @Test
  void reset_setCarPositionToZero() {
    int carCount = 3;
    RacingCarGroup carGroup = new RacingCarGroup(new RacingCarCount(carCount), () -> true);

    carGroup.moveCars();
    carGroup.resetCars();
    List<RacingCar> result = carGroup.copyCars();

    assertThat(result)
        .extracting(RacingCar::getLocation)
        .containsOnly(0);
  }
}
