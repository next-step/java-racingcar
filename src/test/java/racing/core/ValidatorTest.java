package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    @DisplayName("5자 이상 CarName이 들어왔을 때 예외발생 확인")
    void testIfThrowExp(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("jackson"));

        assertThatThrownBy(() -> {validator.validateCarNames(cars);})
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("car name is too long");
    }

    @Test
    @DisplayName("5자 이하 CarName이 들어왔을 때 예외발생 하지 않는지 확인")
    void testIfNotThrowExp(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("jason"));

        validator.validateCarNames(cars);
    }
}
