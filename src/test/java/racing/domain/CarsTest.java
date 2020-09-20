package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("입력한 값 만큼 자동차 생성 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e : 5",
            "aa,bbb,cccc,dddd, : 4"}, delimiter = ':')
    public void create(String carNames, int result) {
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars()).hasSize(result);
    }

    @DisplayName("경주 우승자 테스트")
    @Test
    void findWinners() {

        Car a = new Car(4, "a");
        Car b = new Car(3, "b");
        Car c = new Car(4, "c");
        Car d = new Car(2, "d");

        Cars cars = new Cars(Arrays.asList(a, b, c, d));

        List<Car> winners = cars.findWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains(a, c);
    }

}