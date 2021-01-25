package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    private Racing racing;
    private List<Car> cars;

    @BeforeAll
    static void initAll() {
        System.out.println("start Racing test");
    }

    @BeforeEach
    void beforeEach() {
        cars = Arrays.asList(
                new Car("차량A", 122),
                new Car("차량B", 121),
                new Car("차량C", 13),
                new Car("차량D", 1)
        );
        racing = new Racing(cars, 123);
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("end Racing test");
    }

    @DisplayName("decideMoveTest: 차량이 조건 숫자에 의해 제대로 움직이는지 확인")
    @Test
    void decideMoveTest() {
        racing.decideMove(cars.get(1), 1);
        assertThat(cars.get(1).getDistance()).isEqualTo(121);

        racing.decideMove(cars.get(2), 9);
        assertThat(cars.get(2).getDistance()).isEqualTo(14);

        racing.decideMove(cars.get(3), 5);
        assertThat(cars.get(3).getDistance()).isEqualTo(2);
    }

    @DisplayName("getMaxDistanceTest: 차량들 중 최대 거리가 잘 나오는지 확인")
    @Test
    void getMaxDistanceTest() {
        assertThat(racing.getMaxDistance()).isEqualTo(122);
        racing.decideMove(cars.get(0), 9);
        assertThat(racing.getMaxDistance()).isEqualTo(123);
    }
}