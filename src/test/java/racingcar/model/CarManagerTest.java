package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarManagerTest {
    @Test
    void 우승자_1인() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(13));

        CarManager carManager = new CarManager(Arrays.asList(a, b, c));

        assertThat(carManager.findWinner()).contains("a");
    }

    @Test
    void 우승자_2인() {
        Car a = new Car("a", new Position(10));
        Car b = new Car("b", new Position(12));
        Car c = new Car("c", new Position(12));

        CarManager carManager = new CarManager(Arrays.asList(a, b, c));

        assertThat(carManager.findWinner()).contains("b", "c");
    }

    @Test
    void 빈_목록_생성() {
        assertThatThrownBy(() ->
                new CarManager(new ArrayList<>())
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 차이름_중복() {

        assertThatThrownBy(() ->
                new CarManager(Arrays.asList(new Car("a"), new Car("a")))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}