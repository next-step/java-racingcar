package racing.service;

import org.junit.jupiter.api.Test;
import racing.model.CarPosition;
import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {
    @Test
    void 자동차_3대를_생성하면_정상적으로_3대가_생성되는지() {
        String[] names = {"a", "b", "c"};
        assertThat(new RacingGameService().generateCar(names).size()).isEqualTo(3);
    }
}
