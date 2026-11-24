package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차가 1대이면 그 자동차가 우승이다. (위치 0 → 우승)")
    @Test
    public void test_1() {
        Cars cars = new Cars(List.of(new Car(0, "john")));
        assertThat(cars.getWinners()).containsExactly("john");
    }

    @DisplayName("자동차가 2대 이상일 때 한 대만 가장 앞서면 그 자동차만 우승이다. (위치 3, 1 → 앞선 쪽만 우승)")
    @Test
    public void test_2() {
        Cars cars = new Cars(List.of(new Car(3, "john"), new Car(1, "tom")));
        assertThat(cars.getWinners()).containsExactly("john");
    }

    @DisplayName("자동차가 2대 이상일 때 가장 앞선 위치가 같으면 모두 우승이다. (위치 3, 3 → 둘 다 우승)")
    @Test
    public void test_3() {
        Cars cars = new Cars(List.of(new Car(3, "john"), new Car(3, "tom")));
        assertThat(cars.getWinners()).containsExactly("john", "tom");
    }
}
