package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CarList 테스트")
class CarListTest {
    int carCnt = 5;
    CarList carList = new CarList(Stream.generate(() -> new Car())
            .limit(carCnt)
            .collect(Collectors.toList()));

    @DisplayName("getCarList()")
    @Test
    void getCarList() {
        assertThat(carList.getCarList().size()).isEqualTo(carCnt);
    }

    @DisplayName("getCar()")
    @Test
    void getCar() {
        assertThat(carList.getCar(0)).isInstanceOf(Car.class);
    }
}
