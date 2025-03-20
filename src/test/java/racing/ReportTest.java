package racing;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReportTest {

    @Test
    @DisplayName("전달 받은 인덱스의 자동차의 위치를 반환한다.")
    void finCarByIndexTest() {
        // given
        var carCount = 3;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            var car = new Car("");
            moveCar(car, i);
            cars.add(car);
        }
        var report = new Report(cars);

        // when & then
        for (int i = 0; i < carCount; i++) {
            Assertions.assertThat(report.findCarByIndex(i).getPosition())
                      .isEqualTo(i);
        }
    }

    private void moveCar(Car car, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.move(Car.MOVE_THRESHOLD + 1);
        }
    }

    @Test
    @DisplayName("참가자가 1명이면 챔피온은 바로 그 1명이다.")
    void findChampionWhenOneCarTest() {
        // given
        var car = new Car("a");
        moveCar(car, Car.MOVE_THRESHOLD);

        // when
        var champions = Report.findChampions.apply(List.of(car));

        // then
        Assertions.assertThat(champions)
                  .hasSize(1)
                  .containsExactly(car.getName());
    }

    @Test
    @DisplayName("참가자가 2명이상이고 모두가 같은 위치에 있으면 모두 챔피온이다.")
    void findChampionsAllSamePositionTest() {
        // given
        var car = new Car("a");
        var car2 = new Car("b");
        moveCar(car, Car.MOVE_THRESHOLD);
        moveCar(car2, Car.MOVE_THRESHOLD);
        var cars = List.of(car, car2);
        var expectedChampionNames = List.of(car.getName(), car2.getName());

        // when
        var champions = Report.findChampions.apply(cars);

        // then
        Assertions.assertThat(champions)
                  .hasSize(cars.size())
                  .usingRecursiveComparison()
                  .ignoringCollectionOrder()
                  .isEqualTo(expectedChampionNames);
    }

    @Test
    @DisplayName("참가자가 2명이상이고 다른 위치에 있으면 가장 멀리 있는 참가자가 챔피온이다.")
    void findChampionsDifferentPositionTest() {
        // given
        var car = new Car("a");
        var car2 = new Car("b");
        moveCar(car, Car.MOVE_THRESHOLD);
        var cars = List.of(car, car2);
        var expectedChampionNames = List.of(car.getName());

        // when
        var champions = Report.findChampions.apply(cars);

        // then
        Assertions.assertThat(champions)
                  .hasSize(1)
                  .containsExactlyElementsOf(expectedChampionNames);
    }
}
