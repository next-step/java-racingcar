package racingcar.v1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.v1.domain.Car;
import racingcar.v1.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> carList;
    private int rotation;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("", 20);
        carList = new ArrayList<>();
        carList.add(new Car("a", 3));
        carList.add(new Car("b", 2));
        carList.add(new Car("c", 5));
        carList.add(new Car("d", 5));
        rotation = 20;
    }

    @Test
    void getCarList() {
        List<Car> actualCarList = racingGame.getCarList("a,b,c,d");

        assertThat(actualCarList.stream()
                .map(Car::getName)
                .collect(Collectors.toList()))
                .containsAll(List.of("a", "b", "c", "d"));
        assertThat(actualCarList.stream()
                .mapToInt(Car::getDistance)
                .reduce(0, Integer::sum))
                .isEqualTo(0);
    }

    @Test
    void playSingleLoop() {
        int sumBeforeRace = carList.stream()
                .mapToInt(Car::getDistance)
                .reduce(0, Integer::sum);

        racingGame.playSingleLoop();

        int sumAfterRace = carList.stream()
                .mapToInt(Car::getDistance)
                .reduce(0, Integer::sum);

        assertThat(sumAfterRace).isGreaterThan(sumBeforeRace);
    }

    @Test
    void moveForwardRandom() {
        int moved = 0;
        for (int i = 0; i < rotation; ++i) {
            moved += racingGame.moveForwardRandom();
        }
        assertThat(moved).isLessThan(rotation);
    }

    @Test
    void getWinners() {
        Assertions.assertThat(racingGame.getWinners())
                .containsAll(List.of("c", "d"));
    }
}
