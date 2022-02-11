package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.InputDTO;

public class CarsTest {

    static InputDTO inputDTO;
    static Cars cars;

    @BeforeEach
    void initTest() {
        inputDTO = new InputDTO(Arrays.asList("a", "aa", "aaa"), 10);
        cars = new Cars(inputDTO.getSplitUserInput());
    }

    @DisplayName("입력_자동차_객체_추가_테스트")
    @Test
    void addCarTest() {
        assertAll(
            () -> assertThat(cars.cars().get(0).getName()).isEqualTo("a"),
            () -> assertThat(cars.cars().get(1).getName()).isEqualTo("aa"),
            () -> assertThat(cars.cars().get(2).getName()).isEqualTo("aaa")
        );
    }

    @DisplayName("자동차_전진_여부_테스트")
    @Test
    void driveCarTest() {
        cars.drive(new FixMoveBehavior(true));
        cars.cars()
            .forEach(car -> assertThat(car.getStep()).isEqualTo(1));
    }

    @DisplayName("자동차_전진_최대이동_테스트")
    @Test
    void getMaxStepCarTest() {
        List<Car> cars = CarsTest.cars.doMaxCar(0);
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차_전진_최대이동_개수_테스트")
    @Test
    void fincMaxStepCarTest() {
        cars.cars().stream()
            .map(car -> {
                if (car.getName().equals("a")) {
                    car.moveForward();
                }
                return true;
            })
            .collect(Collectors.toList());

        assertThat(cars.findMaxStepCars()).isEqualTo(1);
    }
}
