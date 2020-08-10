package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.racing.Racing.*;

public class RacingTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void init() {

        cars.add(new Car("애플"));
        cars.add(new Car("삼성"));
        cars.add(new Car("구글"));
    }

    @Test
    void 경주시작_임의값_성공() {
        String carsName = "애플,삼성,구글";
        racingStart(carsName, 5);
    }

    @Test
    void 자동차_초기화_성공() {
        String[] carsArray = {"애플", "삼성", "구글"};
        assertEquals(3, initCars(carsArray).size());
    }

    @Test
    void 자동차_전진_성공() {
        moveCarForward(cars);
    }

    @Test
    void 자동차이름들_유효성_검사() {
        String carsName = "애플,삼성,구글";
        String[] carsArray = validateCarsName(carsName);
        assertEquals(3, carsArray.length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 자동차이름_한글자이상_다섯글자이하_검사(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> validateCarName(name))
                .withMessage("자동차 이름은 최소 1자 이상 5자 이하여야 합니다");
    }
}
