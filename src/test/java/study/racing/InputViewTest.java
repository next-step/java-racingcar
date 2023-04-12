package study.racing;

import org.junit.jupiter.api.Test;
import study.racing.domain.Car;
import study.racing.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private static final int INITIAL_CAR_NUMBER = 10;
    private static final String INITIAL_CAR_NAMES = "car1,car2,car3,car4,car5,car6,car7,car8,car9,car10";

    @Test
    void 자동차_이름을_입력받아_자동차_리스트_생성() {
        List<Car> cars = InputView.readCars(INITIAL_CAR_NAMES);

        assertThat(cars).hasSize(INITIAL_CAR_NUMBER);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
    }

    @Test
    void 자동차_리스트_생성실패() {
        assertThatThrownBy(() -> {
            InputView.readCars("");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차를 입력하지 않았습니다.");
    }
}
