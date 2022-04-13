package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    void Racing_객체에서_자동차_객체가_생성되는가() {
        Racing racing = new Racing(5, 10);
        assertThat(racing.getCars()).hasSize(5);
    }

    @Test
    void 모든_차량_이동이_정상적으로_되는가() {
        Racing racing = new Racing(3, 100);
        racing.StartRacing();
        List<Car> cars = racing.getCars();

        assertThat(cars.stream().filter(c -> c.getStatues().size() > 0)).hasSize(3);
    }

    @Test
    void 랜덤숫자가_정상적으로_만들어지는가() {
        Racing racing = new Racing(1, 100);
        racing.StartRacing();
        List<Car> cars = racing.getCars();

        assertThat(cars.get(0).getStatues()).isNotNull();
    }
}
