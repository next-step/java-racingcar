package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarGroupTest {

  @DisplayName("차들을 move 하면 전략에 따라 차를 움직인다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void tryMoveCars_carsMovedByStrategy(boolean strategyResult) {
    CarCount carCount = CarCount.valueOf(3);
    List<CarName> names = List.of(
        CarName.valueOf("pobi"),
        CarName.valueOf("crong"),
        CarName.valueOf("honux")
    );

    CarGroup carGroupWithCount = CarGroup.valueOf(carCount);
    carGroupWithCount.moveCars(() -> strategyResult);
    List<Car> resultWithCount = carGroupWithCount.copyCars();

    CarGroup carGroupWithNames = CarGroup.valueOf(names);
    carGroupWithNames.moveCars(() -> strategyResult);
    List<Car> resultWithNames = carGroupWithNames.copyCars();

    assertAll(
        () -> assertThat(resultWithCount)
            .extracting(Car::getLocation)
            .containsOnly(strategyResult ? 1 : 0),
        () -> assertThat(resultWithNames)
            .extracting(Car::getLocation)
            .containsOnly(strategyResult ? 1 : 0)
    );
  }

  @DisplayName("차들을 copy 하면 자동차 배열의 깊은 복사를 반환한다.")
  @Test
  void copyCars_returnDeepCopiedCarArray() {
    CarCount carCount = CarCount.valueOf(4);
    List<CarName> names = List.of(
        CarName.valueOf("pobi"),
        CarName.valueOf("crong"),
        CarName.valueOf("honux")
    );

    CarGroup carGroupWithNames = CarGroup.valueOf(names);
    List<Car> firstCopiedCarGroupWithNames = carGroupWithNames.copyCars();
    List<Car> secondCopiedCarGroupWithNames = carGroupWithNames.copyCars();

    CarGroup carGroupWithCount = CarGroup.valueOf(carCount);
    List<Car> firstCopiedCarGroupWithCount = carGroupWithCount.copyCars();
    List<Car> secondCopiedCarGroupWithCount = carGroupWithCount.copyCars();

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
    CarCount carCount = CarCount.valueOf(5);
    List<CarName> names = List.of(
        CarName.valueOf("pobi"),
        CarName.valueOf("crong"),
        CarName.valueOf("honux")
    );

    CarGroup carGroupWithNames = CarGroup.valueOf(names);
    carGroupWithNames.moveCars(() -> true);
    carGroupWithNames.resetCars();
    List<Car> resultWithNames = carGroupWithNames.copyCars();

    CarGroup carGroupWithCount = CarGroup.valueOf(carCount);
    carGroupWithCount.moveCars(() -> true);
    carGroupWithCount.resetCars();
    List<Car> resultWithCount = carGroupWithCount.copyCars();

    assertAll(
        () -> assertThat(resultWithNames)
            .extracting(Car::getLocation)
            .containsOnly(0),
        () -> assertThat(resultWithCount)
            .extracting(Car::getLocation)
            .containsOnly(0)
    );
  }
}
