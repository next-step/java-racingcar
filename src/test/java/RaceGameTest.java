import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameTest {
    private RaceGame game;

    @BeforeEach
    void setUp() {
        game = new RaceGame(List.of("pobi", "crong", "honux"));
    }

    @Test
    @DisplayName("RaceGame 객체를 생성하면 자동차가 carCount개 만큼 생성된다.")
    void createCarTest() {
        assertThat(game.cars()).hasSize(3);
    }

}