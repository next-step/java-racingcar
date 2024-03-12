package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void isEmpty() {
        List<Car> empty = new ArrayList<>();
        assertThatThrownBy(() -> new Cars(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 게임에 참가할 자동차를 1대 이상 입력해주세요");
    }

    @Test
    void moveByTrueStrategy() {
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 2);
        Car car3 = new Car("test3", 3);

        List<Car> given = Arrays.asList(car1, car2, car3);

        Cars cars = new Cars(given);
        Cars moved = cars.move(() -> true);

        assertThat(moved)
                .isEqualTo(new Cars(Arrays.asList(new Car("test1", 2), new Car("test2", 3), new Car("test3", 4))));
    }

    @Test
    void moveByFalseStrategy() {
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 2);
        Car car3 = new Car("test3", 3);

        List<Car> given = Arrays.asList(car1, car2, car3);

        Cars cars = new Cars(given);
        Cars moved = cars.move(() -> false);

        assertThat(cars).isEqualTo(moved);
    }

    @DisplayName("이동시 스냅샵을 생성할 경우 Cars 참조 주소는 모두 다르다")
    @Test
    void moved() {
        Car car1 = new Car("test1", 1);

        List<Car> given = Collections.singletonList(car1);

        Cars cars = new Cars(given);
        Cars moved1 = cars.move(() -> false);// 1
        cars.move(() -> true); // 2
        cars.move(() -> true); // 3
        Cars moved2 = cars.move(() -> false); // 3

        assertThat(moved1).isNotEqualTo(moved2);
    }

    @Test
    void winners() {
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 2);
        Car car3 = new Car("test3", 2);

        List<Car> given = Arrays.asList(car1, car2, car3);

        Cars cars = new Cars(given);
        List<Car> winners = cars.winners();

        assertThat(winners).containsExactly(car2, car3);
    }

}
