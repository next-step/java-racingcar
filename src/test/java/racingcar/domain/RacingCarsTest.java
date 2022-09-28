package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.dto.RacingCarPrintDTO;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void validateEmpty(List<RacingCar> racingCars) {
        assertThrows(RuntimeException.class, () -> new RacingCars(racingCars));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateEmpty(String[] names) {
        assertThrows(RuntimeException.class, () -> new RacingCars(names));
    }

    @Test
    void validateDuplicateName() {
        assertThrows(RuntimeException.class, () -> new RacingCars(new String[]{"same", "same"}));
    }

    @Test
    void size() {
        then(new RacingCars(new String[]{"1", "2"}).size()).isEqualTo(2);
    }

    @Test
    void move() {
        RacingCar racingCar1 = new RacingCar("test1", 0);
        RacingCar racingCar2 = new RacingCar("test2", 1);

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2));
        racingCars.move(List.of(() -> true, () -> true));
        then(racingCar1.getPosition()).isEqualTo(1);
        then(racingCar2.getPosition()).isEqualTo(2);

        racingCars.move(List.of(() -> true, () -> false));
        then(racingCar1.getPosition()).isEqualTo(2);
        then(racingCar2.getPosition()).isEqualTo(2);

        racingCars.move(List.of(() -> false, () -> false));
        then(racingCar1.getPosition()).isEqualTo(2);
        then(racingCar2.getPosition()).isEqualTo(2);
    }

    @Test
    void validateConditionsCount() {
        RacingCars racingCars = new RacingCars(new String[]{"1", "2"});
        assertThrows(RuntimeException.class, () -> racingCars.move(List.of(() -> true)));
        assertThrows(RuntimeException.class, () -> racingCars.move(List.of(() -> true, () -> false, () -> true)));
    }

    @Test
    void constructByNames() {
        then(
            new RacingCars(new String[]{"1", "2", "3", "4"})
        ).isEqualTo(
            new RacingCars(List.of(new RacingCar("1"), new RacingCar("2"), new RacingCar("3"), new RacingCar("4")))
        );
    }

    @Test
    void getWinners() {
        RacingCar racingCar1 = new RacingCar("test1", 0);
        RacingCar racingCar2 = new RacingCar("test2", 1);
        RacingCar racingCar3 = new RacingCar("test3", 2);
        RacingCar racingCar4 = new RacingCar("test4", 3);
        RacingCar racingCar5 = new RacingCar("test5", 3);

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2, racingCar3, racingCar4, racingCar5));
        then(racingCars.getWinners()).isEqualTo(List.of(racingCar4, racingCar5));
    }
}