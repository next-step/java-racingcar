package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rules.MoveRule;
import racingcar.rules.NotMoveRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> new Cars(Arrays.asList("pobi", "crong", "honux")));
    }

    @Test
    @DisplayName("이름이 비어있는 경우")
    void nameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(Collections.emptyList());
        });
    }

    @Test
    @DisplayName("차들이 움직이는가?")
    void moveRule() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(names);
        cars = cars.move(new MoveRule());

        assertEquals(cars.size(), names.size());
        cars.getCars().forEach(car -> assertEquals(1, car.getDistance().getValue()));
    }

    @Test
    @DisplayName("차들이 움직이지 않는다.?")
    void notMoveRule() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(names);
        cars = cars.move(new NotMoveRule());

        assertEquals(cars.size(), names.size());
        cars.getCars().forEach(car -> assertEquals(0, car.getDistance().getValue()));
    }
}
