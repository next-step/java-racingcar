package study.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("입력 값만큼 자동차를 생성")
    @ValueSource(ints = {1,5,10,100})
    @ParameterizedTest
    void createCarList(int expected) {
        List<Car> carList = Collections.nCopies(expected, new Car(new RandomGenerator(new Random())));
        Cars cars = Cars.from(carList);
        assertThat(cars.numberOfCar()).isEqualTo(expected);
    }

}
