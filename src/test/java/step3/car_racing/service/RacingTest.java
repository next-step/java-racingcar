package step3.car_racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car_racing.model.Car;
import step3.car_racing.model.Cars;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    @DisplayName("최종 우승자 찾기")
    void findWinner() {
        // given
        List<String> carNameList = List.of("123", "456");
        Cars cars = new Cars().initCars(carNameList);

        // when
        Racing racing = new Racing(5, cars);
        Cars finalRace = racing.getFinalRace();


        // then
        Optional<Car> optionalCar = finalRace.getCarList().stream().max(Comparator.comparing(Car::getDistanceLength));
        if (optionalCar.isPresent()) {
            String name = optionalCar.get().getName();
            assertThat(racing.getFinalRace().findWinner().contains(name)).isTrue();
        }
    }
}