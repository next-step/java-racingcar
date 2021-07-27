package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rules.MoveRule;
import racingcar.rules.NotMoveRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> {
            List<String> names = Arrays.asList("pobi", "crong", "honux");
            List<Car> carList = names.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
            new Cars(carList);
        });
    }

    @Test
    @DisplayName("자동차가 비어있는 경우")
    void nameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(Collections.emptyList());
        });
    }

    @Test
    @DisplayName("우승자 검증")
    void winners() {
        assertDoesNotThrow(() -> {
            Car pobi = new Car("pobi", 1);
            Car crong = new Car("crong", 2);
            Car hounx = new Car("hounx", 3);

            List<Car> carList = Arrays.asList(pobi, crong, hounx);
            Cars cars = new Cars(carList);
            Winners winners = cars.getWinners();
            List<Name> names = winners.getCars()
                    .stream()
                    .map(Car::getName)
                    .collect(Collectors.toList());

            assertTrue(names.contains(hounx.getName()));
        });
    }

    @Test
    @DisplayName("차들이 움직이는가?")
    void moveRule() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);
        cars = cars.move(new MoveRule());

        assertEquals(cars.getElements().size(), names.size());
        cars.getElements().forEach(car -> assertEquals(1, car.getDistance().getValue()));
    }

    @Test
    @DisplayName("차들이 움직이지 않는다.?")
    void notMoveRule() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);
        cars = cars.move(new NotMoveRule());

        assertEquals(cars.getElements().size(), names.size());
        cars.getElements().forEach(car -> assertEquals(0, car.getDistance().getValue()));
    }
}
