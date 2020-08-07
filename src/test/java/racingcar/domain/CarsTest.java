package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.status.MoveAbility;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private Cars cars;
    private final MoveAbility positiveMoveAbility = () -> true;

    @BeforeEach
    void setUp() {
        List<Car> carList = Arrays.asList(
                new Car("유재석", 5, positiveMoveAbility),
                new Car("이효리", 10, positiveMoveAbility),
                new Car("정지훈", 15, positiveMoveAbility));

        cars = new Cars(carList);
    }

    @DisplayName("우승자 찾기 테스트")
    @Test
    void findWinnersTest() {
        assertThat(cars.findWinners())
                .containsExactly(cars.findFirstPositionCar());
    }

    @DisplayName("Cars 이동 테스트")
    @Test
    void moveCarsTest() {
        cars.moveCars();
        assertAll("cars",
                () -> assertEquals(cars.getCarList().get(0).getPosition(), 6),
                () -> assertEquals(cars.getCarList().get(1).getPosition(), 11),
                () -> assertEquals(cars.getCarList().get(2).getPosition(), 16));
    }
}
