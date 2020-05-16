package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @DisplayName("CarFactory에서 input 값만큼 car 객체들을 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 100})
    public void makeCarListsFromCarFactory(int carCounts) {
        List<Car> cars = CarFactory.makeCars(carCounts);
        assertThat(cars.size()).isEqualTo(carCounts);
    }
}
