package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("단체 생성 테스트")
    public void generateCarsTest() {
        String names = "pobi,brown,honux";
        Cars cars = new Cars(names);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("단체 생성 테스트 - 위치 커스터마이징")
    public void generateCarsTest2() {
        List<Car> cars = List.of(
            new Car("pobi", new Position(3)),
            new Car("honux", new Position(4)),
            new Car("brown", new Position(5)),
            new Car("jiny", new Position(5))
        );
        Cars carGroup = new Cars(cars);
        assertAll(
            () -> assertThat(carGroup.size()).isEqualTo(4),
            () -> assertThat(carGroup.getCarsWithSamePosition(5).size()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("차량 생성 실패 테스트")
    public void failureToGenerateCarsTest() {
        String names = "pobi,brownn,honux";
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }
}
