package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

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

    @DisplayName("이름 개수만큼 자동차가 만들어진다. (이름 3개 → 3대)")
    @Test
    public void test_5() {
        Cars cars = Cars.fromNames(List.of("john", "tom", "jin"));
        assertThat(cars.getWinners()).containsExactly("john", "tom", "jin");
    }

    @DisplayName("이름이 중복되면 RuntimeException (john,john → 실패)")
    @Test
    public void test_4() {
        assertThatThrownBy(() -> new Cars(List.of(new Car("john"), new Car("john"))))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("이름 목록이 비어있으면 RuntimeException (직접 정한 부분)")
    @Test
    public void test_6() {
        assertThatThrownBy(() -> new Cars(List.of()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("비어");
    }

    @DisplayName("자동차들의 위치를 목록으로 알 수 있다. (위치 3, 1 → [3, 1])")
    @Test
    public void test_7() {
        Cars cars = new Cars(List.of(new Car(3, "john"), new Car(1, "tom")));
        assertThat(cars.getPositions()).containsExactly(3, 1);
    }

    @DisplayName("자동차들의 이름별 위치를 순서대로 알 수 있다. (john 3, tom 1)")
    @Test
    public void test_8() {
        Cars cars = new Cars(List.of(new Car(3, "john"), new Car(1, "tom")));
        assertThat(cars.getPositionsByName()).containsExactly(entry("john", 3), entry("tom", 1));
    }

    @DisplayName("4 이상의 값 명령을 내리면 모든 자동차가 전진한다. (4 → 위치 1, 1)")
    @Test
    public void test_9() {
        Cars cars = Cars.fromNames(List.of("john", "tom"));
        cars.move(() -> 4);
        assertThat(cars.getPositions()).containsExactly(1, 1);
    }

    @DisplayName("4 미만의 값 명령을 내리면 모든 자동차가 멈춘다. (3 → 위치 0, 0)")
    @Test
    public void test_10() {
        Cars cars = Cars.fromNames(List.of("john", "tom"));
        cars.move(() -> 3);
        assertThat(cars.getPositions()).containsExactly(0, 0);
    }
}
