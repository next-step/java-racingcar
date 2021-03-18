package step3.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DriversTest {
    @Test
    @DisplayName("우승자가 한 명일 때 테스트")
    void winnerTest() {
        List<Driver> orignal = Arrays.asList(
                new Driver("pobi", new Car(new Position(1))),
                new Driver("crong", new Car(new Position(2))),
                new Driver("honux", new Car(new Position(3))));
        Drivers drivers = new Drivers(orignal);

        assertThat(drivers.getWinnerNames().size()).isEqualTo(1);
        assertThat(drivers.getWinnerNames().contains("honux")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"honux", "crong"})
    @DisplayName("우승자가 두 명일 때 테스트")
    void twoWinnersTest(String winner) {
        List<Driver> orignal = Arrays.asList(
                new Driver("pobi", new Car(new Position(1))),
                new Driver("crong", new Car(new Position(3))),
                new Driver("honux", new Car(new Position(3))));
        Drivers drivers = new Drivers(orignal);

        assertThat(drivers.getWinnerNames().size()).isEqualTo(2);
        assertThat(drivers.getWinnerNames().contains(winner)).isTrue();

    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("모두 우승자일 때 테스트")
    void allWinnerTest(String winner) {
        List<Driver> orignal = Arrays.asList(
                new Driver("pobi", new Car(new Position(3))),
                new Driver("crong", new Car(new Position(3))),
                new Driver("honux", new Car(new Position(3))));
        Drivers drivers = new Drivers(orignal);

        assertThat(drivers.getWinnerNames().size()).isEqualTo(3);
        assertThat(drivers.getWinnerNames().contains(winner)).isTrue();
    }
}
