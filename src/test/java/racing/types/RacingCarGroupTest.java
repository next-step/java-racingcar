package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGroupTest {

  @DisplayName("차들을 move 하면 전략에 따라 차를 움직인다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void tryMoveCars_carsMovedByStrategy(boolean strategyResult) {
    RacingCarCount carCount = new RacingCarCount(3);
    List<RacingCarName> names = List.of(
        new RacingCarName("pobi"),
        new RacingCarName("crong"),
        new RacingCarName("honux")
    );

    RacingCarGroup carGroupWithCount = new RacingCarGroup(carCount, () -> strategyResult);
    carGroupWithCount.moveCars();
    List<RacingCar> resultWithCount = carGroupWithCount.copyCars();

    RacingCarGroup carGroupWithNames = new RacingCarGroup(names, () -> strategyResult);
    carGroupWithNames.moveCars();
    List<RacingCar> resultWithNames = carGroupWithNames.copyCars();

    assertAll(
        () -> assertThat(resultWithCount)
            .extracting(RacingCar::getLocation)
            .containsOnly(strategyResult ? 1 : 0),
        () -> assertThat(resultWithNames)
            .extracting(RacingCar::getLocation)
            .containsOnly(strategyResult ? 1 : 0)
    );
  }

  @DisplayName("차들을 copy 하면 자동차 배열의 깊은 복사를 반환한다.")
  @Test
  void copyCars_returnDeepCopiedCarArray() {
    RacingCarCount carCount = new RacingCarCount(4);
    List<RacingCarName> names = List.of(
        new RacingCarName("pobi"),
        new RacingCarName("crong"),
        new RacingCarName("honux")
    );

    RacingCarGroup carGroupWithNames = new RacingCarGroup(names, () -> true);
    List<RacingCar> firstCopiedCarGroupWithNames = carGroupWithNames.copyCars();
    List<RacingCar> secondCopiedCarGroupWithNames = carGroupWithNames.copyCars();

    RacingCarGroup carGroupWithCount = new RacingCarGroup(carCount, () -> true);
    List<RacingCar> firstCopiedCarGroupWithCount = carGroupWithCount.copyCars();
    List<RacingCar> secondCopiedCarGroupWithCount = carGroupWithCount.copyCars();

    assertAll(
        () -> assertThat(firstCopiedCarGroupWithNames).hasSize(names.size()),
        () -> assertThat(secondCopiedCarGroupWithNames).hasSize(names.size()),
        () -> assertThat(firstCopiedCarGroupWithNames)
            .zipSatisfy(secondCopiedCarGroupWithNames, (element1, element2) -> assertThat(element1).isNotSameAs(element2)),
        () -> assertThat(firstCopiedCarGroupWithCount).hasSize(carCount.getCount()),
        () -> assertThat(secondCopiedCarGroupWithCount).hasSize(carCount.getCount()),
        () -> assertThat(firstCopiedCarGroupWithCount)
            .zipSatisfy(secondCopiedCarGroupWithCount, (element1, element2) -> assertThat(element1).isNotSameAs(element2))

    );
  }

  @DisplayName("차들을 reset 하면 차의 위치가 0이 된다.")
  @Test
  void reset_setCarPositionToZero() {
    RacingCarCount carCount = new RacingCarCount(5);
    List<RacingCarName> names = List.of(
        new RacingCarName("pobi"),
        new RacingCarName("crong"),
        new RacingCarName("honux")
    );

    RacingCarGroup carGroupWithNames = new RacingCarGroup(names, () -> true);
    carGroupWithNames.moveCars();
    carGroupWithNames.resetCars();
    List<RacingCar> resultWithNames = carGroupWithNames.copyCars();

    RacingCarGroup carGroupWithCount = new RacingCarGroup(carCount, () -> true);
    carGroupWithCount.moveCars();
    carGroupWithCount.resetCars();
    List<RacingCar> resultWithCount = carGroupWithCount.copyCars();

    assertAll(
        () -> assertThat(resultWithNames)
            .extracting(RacingCar::getLocation)
            .containsOnly(0),
        () -> assertThat(resultWithCount)
            .extracting(RacingCar::getLocation)
            .containsOnly(0)
    );
  }
}
