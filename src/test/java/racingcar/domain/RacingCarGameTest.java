package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarGameTest {

    @Test
    @DisplayName("동일 순위 우승자")
    void winner_same_rank() {
        //given
        RacingCars racingCars = new RacingCars("a,b,c") {
            @Override
            protected List<Car> createRacingCars(String name) {
                ArrayList<Car> cars = new ArrayList<>();
                cars.add(new Car("a", ((min, max) -> 5)));
                cars.add(new Car("b", ((min, max) -> 5)));
                cars.add(new Car("c", ((min, max) -> 5)));
                return cars;
            }
        };
        //when
        racingCars.race();
        RacingCarGame racingCarGame = new RacingCarGame();
        Winners winners = racingCarGame.pickWinners(racingCars);
        List<Car> winnersList = winners.showWinners();
        //then
        assertThat(winnersList).hasSize(3);
    }

    @Test
    @DisplayName("우승자 1명 테스트")
    void winner_() {
        //given
        RacingCars racingCars = new RacingCars("a,b,c") {
            @Override
            protected List<Car> createRacingCars(String name) {
                ArrayList<Car> cars = new ArrayList<>();

                Car a = new Car("a", ((min, max) -> 5));
                a.run();

                cars.add(a);
                cars.add(new Car("b", ((min, max) -> 5)));
                cars.add(new Car("c", ((min, max) -> 5)));
                return cars;
            }
        };
        //when
        racingCars.race();
        RacingCarGame racingCarGame = new RacingCarGame();
        Winners winners = racingCarGame.pickWinners(racingCars);
        List<Car> winnersList = winners.showWinners();
        //then
        assertAll(
                () -> assertThat(winnersList).hasSize(1),
                () -> assertThat(winnersList.get(0).showName()).isEqualTo("a")
        );

    }
}