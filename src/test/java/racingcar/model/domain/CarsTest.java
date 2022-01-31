package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.InputDTO;
import racingcar.model.vo.Car;

public class CarsTest {

    @DisplayName("일급_컬렉션_테스트")
    @Test
    void collectionTest() {
        final InputDTO inputDTO = new InputDTO(Arrays.asList("a", "aa", "aaa"), 10);
        final Cars cars = new Cars(inputDTO.getSplitUserInput());
        final List<Car> carsTest = cars.cars();
        assertAll(
            () -> assertThat(carsTest.get(0).getName()).isEqualTo("a"),
            () -> assertThat(carsTest.get(1).getName()).isEqualTo("aa"),
            () -> assertThat(carsTest.get(2).getName()).isEqualTo("aaa")
        );
    }
}
