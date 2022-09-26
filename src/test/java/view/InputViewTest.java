package view;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    @Test
    void 입력한댓수만큼_자동차_생성() {
        List<Car> cars = InputView.makeCar(3);
        assertThat(cars.size()).isEqualTo(3);
    }
}