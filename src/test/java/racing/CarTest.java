package racing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 차가_정상적으로_이동_되었는가() {
        Car car = new Car();
        car.moveCar(0);
        car.moveCar(1);
        car.moveCar(4);
        List<Boolean> statues = car.getStatues();

        assertThat(statues.stream().filter(s -> s).collect(Collectors.toList())).hasSize(1);
    }

    @Test
    void 차가_세번째_시도에_이동이_정상적으로_되었는가() {
        Car car = new Car();
        car.moveCar(0);
        car.moveCar(1);
        car.moveCar(4);
        List<Boolean> statues = car.getStatues();

        assertThat(car.getStatues().get(2)).isTrue();
    }

    @Test
    void 차가_세번째_시도에_정상적으로_이동이_무시_되었는가() {
        Car car = new Car();
        car.moveCar(0);
        car.moveCar(1);
        car.moveCar(0);
        List<Boolean> statues = car.getStatues();

        assertThat(car.getStatues().get(2)).isFalse();
    }
    

}
