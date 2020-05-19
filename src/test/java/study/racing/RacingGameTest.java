package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.racing.model.Car;
import study.racing.ui.ResultView;

import java.util.ArrayList;
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
            car.move();
            assertThat(car.getCount()).isBetween(0, 1);
        }
    }

    @Test
    void sort() {
        for(int i=0; i<10; i++) {
            for(Car car : carList) {
                car.move();
            }
        }

        Collections.sort(carList);

        assertThat(carList.get(0).getCount()).isLessThanOrEqualTo(carList.get(carList.size()-1).getCount());
    }
}
