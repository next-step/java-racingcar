package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(3, new String[]{"임형준", "임횽준", "임항준"});
    }

    @DisplayName("세 번 전부 차의 전진 조건을 만족시키지 못하면 거리가 증가하지 않는 것을 보여준다")
    @Test
    void stop_test() {
        List<Integer> firstMileages = cars.goForward(() -> false);
        assertThat(firstMileages.get(0)).isEqualTo(0);
        assertThat(firstMileages.get(1)).isEqualTo(0);
        assertThat(firstMileages.get(2)).isEqualTo(0);

        List<Integer> secondMileages = cars.goForward(() -> false);
        assertThat(secondMileages.get(0)).isEqualTo(0);
        assertThat(secondMileages.get(1)).isEqualTo(0);
        assertThat(secondMileages.get(2)).isEqualTo(0);

        List<Integer> thirdMileages = cars.goForward(() -> false);
        assertThat(thirdMileages.get(0)).isEqualTo(0);
        assertThat(thirdMileages.get(1)).isEqualTo(0);
        assertThat(thirdMileages.get(2)).isEqualTo(0);
    }

    @DisplayName("세 번 전부 차의 전진 조건을 만족시키면 거리가 1씩 증가하는 것을 보여준다")
    @Test
    void goForward_test() {
        List<Integer> firstMileages = cars.goForward(() -> true);
        assertThat(firstMileages.get(0)).isEqualTo(1);
        assertThat(firstMileages.get(1)).isEqualTo(1);
        assertThat(firstMileages.get(2)).isEqualTo(1);

        List<Integer> secondMileages = cars.goForward(() -> true);
        assertThat(secondMileages.get(0)).isEqualTo(2);
        assertThat(secondMileages.get(1)).isEqualTo(2);
        assertThat(secondMileages.get(2)).isEqualTo(2);

        List<Integer> thirdMileages = cars.goForward(() -> true);
        assertThat(thirdMileages.get(0)).isEqualTo(3);
        assertThat(thirdMileages.get(1)).isEqualTo(3);
        assertThat(thirdMileages.get(2)).isEqualTo(3);
    }

}
