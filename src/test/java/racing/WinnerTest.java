package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerTest {
    private List<Car> carList;
    private Cars cars;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi",3));
        carList.add(new Car("crong",7));
        carList.add(new Car("honux",5));
        cars = new Cars(carList);
    }

    @Test
    void 우승자선별() {
        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.getMaxPosition()).isEqualTo(new CarPosition(7)),
                () -> assertThat(winner.getNames()).isEqualTo("crong")
        );
    }

    @Test
    void 우승자선별_공동우승() {
        carList.add(new Car("conan",7));
        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.getMaxPosition()).isEqualTo(new CarPosition(7)),
                () -> assertThat(winner.getNames()).isEqualTo("crong, conan")
        );
    }
}