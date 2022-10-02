package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.rule.move.RandomMove;

import java.util.Arrays;
import java.util.List;

public class RoundTest {

    @Test
    void 경주차목록_불변성_검증() {
        Round round = new Round(Arrays.asList(new Car("car1"), new Car("car2")), new RandomMove());
        List<Car> cars = round.getCars();

        Assertions.assertThatThrownBy(() -> cars.add(new Car("car3")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
