package racing.car;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    void 주어진_횟수만큼_자동차생성(){
        int count = 4;
        List<Car> list = CarFactory.makeCar(count);
        assertThat(list).hasSize(4);
    }
}
