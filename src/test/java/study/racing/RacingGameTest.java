package study.racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racing.model.Car;
import study.racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void move_with_numbers_under_4(int value) {
        Car car = new Car("test");
        car.move(value);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9, 10 })
    void move_with_numbers_over_4(int value) {
        Car car = new Car("test");
        car.move(value);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void get_winner_position() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));

        List<Integer> moves = Arrays.asList(1, 5, 4);

        for(int i=0; i<carList.size(); i++) {
            for(int j=0; j<moves.get(i); j++) {
                carList.get(i).move(5);
            }
        }

        assertThat(RacingUtils.getWinners(carList).get(0).getPosition())
                .isEqualTo(Collections.max(moves));
    }
}
