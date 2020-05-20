package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racing.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private List<Car> carList;

    @BeforeEach
    private void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("car1"));
        carList.add(new Car("car2"));
        carList.add(new Car("car3"));
    }

    @Test
    void move() {
        for(Car car : carList) {
            for(int i=0; i<5; i++) {
                car.move();
            }

            assertThat(car.getPosition()).isEqualTo(5);
        }
    }


    @Test
    void sort() {
        List<Integer> moves = Arrays.asList(1, 5, 4);

        for(int i=0; i<carList.size(); i++) {
            for(int j=0; j<moves.get(i); j++) {
                carList.get(i).move();
            }
        }

        Collections.sort(carList);
        Collections.sort(moves);

        for(int i=0; i<carList.size(); i++) {
            assertThat(carList.get(i).getPosition()).isEqualTo(moves.get(i));
        }
    }
}
