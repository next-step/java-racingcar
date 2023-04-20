package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerTest {
    @Test
    void 우승자선별() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.findOne(0).move(3);
        cars.findOne(1).move(7);
        cars.findOne(2).move(5);
        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.getMaxMoveStatus()).isEqualTo(7),
                () -> assertThat(winner.getName()).isEqualTo("crong")
        );
    }

    @Test
    void 우승자선별_공동우승() {
        Cars cars = new Cars("pobi,crong,honux,conan");
        cars.findOne(0).move(3);
        cars.findOne(1).move(7);
        cars.findOne(2).move(5);
        cars.findOne(3).move(7);

        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.getMaxMoveStatus()).isEqualTo(7),
                () -> assertThat(winner.getName()).isEqualTo("crong, conan")
        );
    }
}