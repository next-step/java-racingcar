package racingcar.v1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("q, w, e, r, t", 20);
        racingGame.getCarList().get(0).addDistance(3);
        racingGame.getCarList().get(1).addDistance(2);
        racingGame.getCarList().get(2).addDistance(5);
        racingGame.getCarList().get(3).addDistance(5);
        racingGame.getCarList().get(4).addDistance(10);
    }

    @Test
    void parseCarListFromString() {
        List<Car> actualCarList = racingGame.parseCarListFromString("a,b,c,d");

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
    void getCarList() {
        assertThat(racingGame.getCarList().stream()
                .map(Car::getName)
                .collect(Collectors.toList())
                .containsAll(List.of("q", "w", "e", "r", "t"))).isTrue();
    }

    @Test
    void isEnd() {
        RacingGame finishedGame = new RacingGame("a, b", 0);

        assertThat(racingGame.isEnd()).isFalse();
        assertThat(finishedGame.isEnd()).isTrue();
    }

    @Test
    void playSingleLoop() {
        int sumBeforeRace = racingGame.getCarList().stream()
                .mapToInt(Car::getDistance)
                .reduce(0, Integer::sum);

        racingGame.playSingleLoop();

        int sumAfterRace = racingGame.getCarList().stream()
                .mapToInt(Car::getDistance)
                .reduce(0, Integer::sum);

        assertThat(sumAfterRace).isGreaterThan(sumBeforeRace);
    }

    @Test
    void moveForwardRandom() {
        int moved = 0;
        for (int i = 0; i < 10; ++i) {
            moved += racingGame.moveForwardRandom();
        }
        assertThat(moved).isLessThan(10);
    }

    @Test
    void getMaxDistance() {
        assertThat(racingGame.getMaxDistance(racingGame.getCarList())).isEqualTo(10);

        racingGame.getCarList().remove(4);

        assertThat(racingGame.getMaxDistance(racingGame.getCarList())).isEqualTo(5);
    }

    @Test
    void getNamesAbove() {
        assertThat(racingGame.getNamesAbove(racingGame.getCarList(), 5)).containsAll(List.of("e", "r", "t"));
        assertThat(racingGame.getNamesAbove(racingGame.getCarList(), 9)).containsAll(List.of("t"));
    }

    @Test
    void getWinners() {
        Assertions.assertThat(racingGame.getWinners())
                .containsAll(List.of("t"));

        racingGame.getCarList().remove(4);

        Assertions.assertThat(racingGame.getWinners())
                .containsAll(List.of("e", "r"));
    }
}
