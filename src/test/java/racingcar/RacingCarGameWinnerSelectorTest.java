package racingcar;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarGameWinnerSelectorTest {

    private RacingCar createRacingCar(String name, int position) {
        RacingCar racingCar = new RacingCar(name);

        for (int i = 0; i < position; i++) {
            racingCar.move(() -> true);
        }
        return racingCar;
    }

    @Test
    @DisplayName("여러 자동차들 중 우승자 선별")
    void getWinnerRacingCars() {
        RacingCar racingCar1 = createRacingCar("test1", 1);
        RacingCar racingCar2 = createRacingCar("test2", 2);
        RacingCar racingCar3 = createRacingCar("test3", 3);
        RacingCar racingCar4 = createRacingCar("test4", 3);
        RacingCar racingCar5 = createRacingCar("test5", 3);

        then(RacingCarGameWinnerSelector.getWinnerRacingCars(
            List.of(racingCar1, racingCar2, racingCar3, racingCar4, racingCar5)
        )).isEqualTo(List.of(racingCar3, racingCar4, racingCar5));
    }

    @Test
    @DisplayName("빈 리스트로 우승자 선별시 NoSuchElementException 예외 발생")
    void getWinnerRacingCarsWithEmptyList() {
        assertThrows(NoSuchElementException.class,
            () -> RacingCarGameWinnerSelector.getWinnerRacingCars(List.of())
        );
    }
}