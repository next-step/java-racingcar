package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import strategy.AboveNumberMove;
import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomNumberGenerator;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Set<String> players = new HashSet<>();

    @BeforeEach
    void setUp() {
        players.add("pobi");
        players.add("crong");
        players.add("honux");
    }

    @DisplayName("레이싱 게임을 위한 자동차가 입력받은 개수만큼 생성되는지 확인한다")
    @Test
    void makeCars() {
        Cars cars = new Cars(players, new AboveNumberMove(4), new RandomNumberGenerator());

        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void race() {
        Cars cars = new Cars(players, new AboveNumberMove(0), new RandomNumberGenerator());

        cars.race();

        assertThat(cars.getCars()).extracting(Car::getLocation).containsExactly(1, 1, 1);
    }

    @Test
    void getWinner() {
        Cars cars = new Cars(players, new AboveNumberMove(0), new RandomNumberGenerator());

        String winners = cars.getWinners();

        assertThat(winners).contains(players);
    }
}
