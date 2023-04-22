package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerTest {
    @Test
    void 우승자선별() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",3));
        carList.add(new Car("crong",7));
        carList.add(new Car("honux",5));
        Cars cars = new Cars(carList);

        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.getMaxPosition()).isEqualTo(7),
                () -> assertThat(winner.getName()).isEqualTo("crong")
        );
    }

    @Test
    void 우승자선별_공동우승() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi",3));
        carList.add(new Car("crong",7));
        carList.add(new Car("honux",5));
        carList.add(new Car("conan",7));
        Cars cars = new Cars(carList);

        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.getMaxPosition()).isEqualTo(7),
                () -> assertThat(winner.getName()).isEqualTo("crong, conan")
        );
    }
}