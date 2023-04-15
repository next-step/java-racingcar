package domain.record;

import domain.car.Car;
import domain.car.Cars;
import domain.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;
import vo.CarRecord;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class RecordsTest {

    @Test
    void 주행_거리가_긴_자동차가_우승한다() {

        // given
        Car loser = new Car("alex");
        Car winner = new Car("jack");
        loser.go(() -> false);
        winner.go(() -> true);

        List<Car> carList = Arrays.asList(loser, winner);
        Cars cars = new Cars(carList, new RandomStrategy());
        Records records = new Records();

        // when
        records.add(cars);
        records.addWinners();

        List<CarRecord> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(1);
            softAssertions.assertThat(result.get(0).name()).isEqualTo("jack");
            softAssertions.assertThat(result.get(0).distance())
                    .isGreaterThan(loser.distance());
        });
    }

    @Test
    void 우승자는_한명_이상일_수_있다() {

        // given
        Car firstWinner = new Car("alex");
        Car secondWinner = new Car("jack");
        firstWinner.go(() -> true);
        secondWinner.go(() -> true);

        List<Car> carList = Arrays.asList(firstWinner, secondWinner);
        Cars cars = new Cars(carList, new RandomStrategy());
        Records records = new Records();

        // when
        records.add(cars);
        records.addWinners();

        List<CarRecord> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(2);
            softAssertions.assertThat(result.get(0).name()).isEqualTo("alex");
            softAssertions.assertThat(result.get(1).name()).isEqualTo("jack");
            softAssertions.assertThat(result.get(0).distance())
                    .isEqualTo(result.get(1).distance());
        });
    }
}
