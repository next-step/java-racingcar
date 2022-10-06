package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 이름_여러개_문자열로_받기() {
        List<Car> cars = Arrays.asList(new Car("jigu"), new Car("gogu"), new Car("dal"));
        assertThat((new Cars("jigu,gogu,dal"))).isEqualTo(new Cars(cars));
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = Arrays.asList(new Car("jigu", 3), new Car("gogu", 1), new Car("dal", 1));
        assertThat(new Cars(cars).findWinnerNames()).contains("jigu");
    }
}
