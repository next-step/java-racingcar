package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.Car;
import racing.car.ReadOnlyCarProxy;
import racing.car.ReadonlyCar;
import racing.dto.RacingReport;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingTest {

    @Test
    @DisplayName("경주가 끝나면 경기 결과를 반환한다.")
    void returnRacingReportAfterRacing() {
        Car pobiCar = new Car(() -> 1, "pobi");
        Car crongCar = new Car(() -> 2, "crong");
        Car honuxCar = new Car(() -> 3, "honux");
        Car jkCar = new Car(() -> 3, "jk");

        List<Car> carList = Arrays.asList(pobiCar, crongCar, honuxCar, jkCar);

        Racing racing = new Racing(carList, 1);

        RacingReport actual = racing.start();
        List<ReadonlyCar> readonlyCarList = actual.getRoundResults()
                                                  .get(0)
                                                  .getCarList();

        List<ReadonlyCar> convertedCarList = carList.stream()
                                                    .map(ReadOnlyCarProxy::new)
                                                    .collect(Collectors.toList());

        assertAll(
            () -> assertThat(actual.getWinners()).containsExactly(honuxCar.getName(), jkCar.getName()),
            () -> assertThat(readonlyCarList).containsExactlyElementsOf(convertedCarList)
        );
    }

}
