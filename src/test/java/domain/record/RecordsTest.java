package domain.record;

import domain.car.Car;
import domain.car.Cars;
import strategy.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vo.CarRecord;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class RecordsTest {

    Car firstCar;
    Car secondCar;
    Records records;

    @BeforeEach
    void init() {
        firstCar = new Car("alex");
        secondCar = new Car("jack");
        records = new Records();

        firstCar.go(() -> true);
        secondCar.go(() -> true);
    }

    @Test
    void 주행_거리가_긴_자동차가_우승한다() {

        // given
        firstCar.go(() -> true);

        List<Car> carList = Arrays.asList(firstCar, secondCar);
        Cars cars = new Cars(carList, new RandomStrategy());

        // when
        records.add(cars);

        List<CarRecord> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(1);
            softAssertions.assertThat(result).contains(new CarRecord("alex", 2));
            softAssertions.assertThat(result.get(0).distance())
                    .isGreaterThan(secondCar.distance());
        });
    }

    @Test
    void 우승자는_한명_이상일_수_있다() {

        // given
        List<Car> carList = Arrays.asList(firstCar, secondCar);
        Cars cars = new Cars(carList, new RandomStrategy());

        // when
        records.add(cars);

        List<CarRecord> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(2);
            softAssertions.assertThat(result).contains(new CarRecord("alex", 1));
            softAssertions.assertThat(result).contains(new CarRecord("jack", 1));
            softAssertions.assertThat(result.get(0).distance())
                    .isEqualTo(result.get(1).distance());
        });
    }
}
