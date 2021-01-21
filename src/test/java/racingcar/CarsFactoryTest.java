package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsFactoryTest {
    @DisplayName("자동차들의 이름이 null인 경우 exception 발생")
    @Test
    void carNamesNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarsFactory.createCars(null, new TrueMoveChecker());
        });
        assertThat(exception.getMessage()).isEqualTo("입력값이 없습니다.");
    }

    @DisplayName("각 자동차 이름의 길이가 5자를 초과하면 exception 발생")
    @Test
    void carNameLengthLongerThanFive() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarsFactory.createCars("car1,gyumin,sanghyun", new TrueMoveChecker());
        });
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름에 따라서 자동차들 객체를 잘 생성하는지 확인")
    @Test
    void createCars() {
        MoveChecker moveChecker = new TrueMoveChecker();
        Cars cars = CarsFactory.createCars("car1,car2,car3", moveChecker);

        assertThat(cars).isEqualTo(
            new Cars(
                new ArrayList<Car>() {{
                    add(new Car("car1", 0));
                    add(new Car("car2", 0));
                    add(new Car("car3", 0));
                }},
                moveChecker
            )
        );
    }
}