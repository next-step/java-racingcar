import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameTest {
    private static final Car POBI = new Car("pobi", 5);
    private static final Car CRONG = new Car("crong", 3);
    private static final Car HONUX = new Car("honux", 7);
    private RaceGame game;

    @BeforeEach
    void setUp() {
        game = new RaceGame(List.of(POBI, CRONG, HONUX));
    }

    @Test
    @DisplayName("RaceGame 객체를 생성하면 자동차가 carCount개 만큼 생성된다.")
    void createCarTest() {
        assertThat(game.cars()).hasSize(3);
    }

    @Test
    @DisplayName("RaceGame 객체에서 우승자를 정확히 반환한다.")
    void getWinnersTest() {
        Winners winners = game.getWinners();
        assertThat(winners.winners()).containsExactly(HONUX);
    }
}