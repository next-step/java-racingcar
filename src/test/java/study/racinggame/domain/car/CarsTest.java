package study.racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("position 값으로 우승자를 구한다")
    void shouldReturnWinner() {
        Car pobi = new Car(new Name("pobi"), 3);
        Car jake = new Car(new Name("jake"), 5);
        Car sam = new Car(new Name("sam"), 5);
        Cars cars = new Cars(Arrays.asList(pobi, jake, sam));

        assertThat(cars.winners()).contains(jake, sam);
    }

    @Test
    @DisplayName("주어진 이름으로 생성한 Car 객체를 가진다")
    void shouldCreateCarsWithNames() {
        Car pobi = new Car("pobi");
        Car jake = new Car("jake");
        Car sam = new Car("sam");
        Cars cars = new Cars(new Names("pobi,jake,sam"));

        assertThat(cars.getCars()).containsExactly(pobi, jake, sam);
    }
}