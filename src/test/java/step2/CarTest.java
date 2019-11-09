package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.move.DefaultMove;
import step2.move.MoveStrategy;
import step2.racing.Car;
import step2.racing.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private Car car = new Car("tank", 5);
    private Car car1, car2;

    @BeforeEach
    void setUp() {
        MoveStrategy moveStrategy = new DefaultMove();
        car1 = new Car("bus", 5);
        car1.move(moveStrategy, 1);
        car1.move(moveStrategy, 2);
        car1.move(moveStrategy, 3);
        car1.move(moveStrategy, 4);
        car2 = new Car("taxi", 5);
        car2.move(moveStrategy, 0);
        car2.move(moveStrategy, 1);
        car2.move(moveStrategy, 3);
    }

    @Test
    void getScoreByTurn() {
        assertAll(
                () -> assertThat(car2.getScoreByTurn(0)).isEqualTo(1),
                () -> assertThat(car2.getScoreByTurn(1)).isEqualTo(2),
                () -> assertThat(car2.getScoreByTurn(2)).isEqualTo(2),
                () -> assertThat(car2.getScoreByTurn(3)).isEqualTo(3),
                () -> assertThat(car2.getScoreByTurn(4)).isEqualTo(3)
        );
    }

    @Test
    void getFinalScore() {
        assertThat(car1.getFinalScore()).isEqualTo(4);
        assertThat(car2.getFinalScore()).isEqualTo(3);
    }

    @Test
    void addWinner() {
        List<Car> cars = new ArrayList<>(Arrays.asList(car1, car2));
        assertThat(Car.winners(cars))
                .isEqualTo(Collections.singletonList(new Model("bus")));

    }

}