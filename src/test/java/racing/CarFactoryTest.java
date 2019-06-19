package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {


    @ParameterizedTest
    @ValueSource(ints = {
            5, 4, 3, 2, 1
    })
    public void createByCount(int count) {
        assertThat(CarFactory.createByCount(count).size()).isEqualTo(count);
    }
}
