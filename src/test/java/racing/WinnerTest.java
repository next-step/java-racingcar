package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerTest {
    @Test
    void 우승자선별() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.find(0).moveStatus = 3;
        cars.find(1).moveStatus = 7;
        cars.find(2).moveStatus = 5;

        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.moveStatus).isEqualTo(7),
                () -> assertThat(winner.name).isEqualTo("crong")
        );
    }

    @Test
    void 우승자선별_공동우승() {
        Cars cars = new Cars("pobi,crong,honux,conan");
        cars.find(0).moveStatus = 3;
        cars.find(1).moveStatus = 7;
        cars.find(2).moveStatus = 5;
        cars.find(3).moveStatus = 7;

        Winner winner = new Winner(cars);
        assertAll(
                () -> assertThat(winner.moveStatus).isEqualTo(7),
                () -> assertThat(winner.name).isEqualTo("crong, conan")
        );
    }
}