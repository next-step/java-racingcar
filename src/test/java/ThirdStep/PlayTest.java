package ThirdStep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {

    private List<Car> cars = new ArrayList<>();
    final private int INIT_ATTEMPTS = 5;

    @BeforeEach
    void setCars() {
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
    }


    @Test
    @DisplayName("racing 함수가 종료되어도 처음 전달된 attempts 값은 유지된다.")
    void racing_test() {
        int attempts = INIT_ATTEMPTS;

        Play.racing(cars, attempts);

        assertThat(attempts).isEqualTo(INIT_ATTEMPTS);
    }
}
