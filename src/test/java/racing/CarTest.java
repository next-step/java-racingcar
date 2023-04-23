package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 자동차_정지() {
        Car car = new Car("june");

        car.move(() -> false);
        assertThat(car.position().getPosition()).isZero();
    }

    @Test
    void 자동차_이동() {
        Car car = new Car("june");

        car.move(() -> true);
        assertThat(car.position().getPosition()).isEqualTo(1);
    }

    @Test
    void 모든_자동차들은_이동횟수만큼_이동한다() {
        Cars movedCars = new Cars(List.of("a", "b", "c"), 3).move();
        movedCars.values()
                .forEach(car -> {
                    assertThat(car.position().getPosition()).isBetween(0, 3);
                });
    }

    @Test
    void 자동차에_이름을_부여() {
        List<String> names = List.of("pobi", "crong", "honux");
        int moveCount = 5;

        Cars cars = new Cars(names, moveCount);
        for (int i = 0; i < 3; i++) {
            assertThat(cars.values().get(i).name().getNameString()).isEqualTo(names.get(i));
        }
    }

    @Test
    void 이름이_5자_초과시_에러() {
        List<String> names = List.of("pobiaaaaa", "crong", "honux");
        int moveCount = 5;

        assertThatThrownBy(() -> new Cars(names, moveCount))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 이동이_끝나면_우승자_선출() {
        Cars cars = new Cars(5, List.of(new Car("pobi", 5), new Car("crong", 2), new Car("honux", 3)));
        assertThat(cars.pickWinners()).isEqualTo(List.of("pobi"));
    }

    @Test
    void 이동이_끝나면_우승자_목록_선출() {
        Cars cars = new Cars(5, List.of(new Car("pobi", 5), new Car("crong", 5), new Car("honux", 3)));
        assertThat(cars.pickWinners()).isEqualTo(List.of("pobi", "crong"));
    }
}
